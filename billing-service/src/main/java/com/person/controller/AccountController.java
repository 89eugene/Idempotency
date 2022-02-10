package com.person.controller;

import com.person.client.Sender;
import com.person.client.dto.Message;
import com.person.controller.dto.AccountRequest;
import com.person.controller.dto.BalanceInfoResponse;
import com.person.controller.dto.BalanceResponse;
import com.person.controller.dto.CreateAccountResponse;
import com.person.exception.UserNotFoundException;
import com.person.models.Account;
import com.person.models.Operation;
import com.person.models.OperationHistory;
import com.person.repository.AccountRepository;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;

import static com.person.models.Operation.FILL_UP;
import static com.person.models.Operation.WRITE_OFF;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/account")
public class AccountController {

    private static final String DONT_ENOUGH_MONEY_MESSAGE = "Недостаточно денежных средств на счете";
    private static final String ORDER_CREATED = "Был успешно сформирован заказ";
    private static final String FILL_UP_BALANCE = "Баланс успешно пополнен";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private Sender kafkaSender;

    @PostMapping("/createAccount")
    public ResponseEntity<CreateAccountResponse> createAccount(@RequestBody AccountRequest accountRequest) {
        Account account = new Account();
        account.setLogin(accountRequest.getLogin());
        account.setOperationHistories(Collections.singletonList(new OperationHistory(0.0D, Operation.CREATE)));
        accountRepository.save(account);
        return  ResponseEntity.ok().body(new CreateAccountResponse(true));
    }

    @GetMapping("/")
    public ResponseEntity<BalanceInfoResponse>  getBalance( @RequestParam(value = "login") String login) {

        final BodyBuilder response = ResponseEntity.ok();
        Account account = accountRepository.findByLogin(login)
            .orElseThrow(() -> new UserNotFoundException(login));

        return  response.body(new BalanceInfoResponse(account.getOperationHistories().stream().mapToDouble(OperationHistory::getAmount).sum()));
    }

    @PutMapping("/operation")
    public ResponseEntity<BalanceResponse> executeOperation(@RequestBody AccountRequest accountRequest) {

        String login = accountRequest.getLogin();
        Account account = accountRepository.findByLogin(login)
            .orElseThrow(() -> new UserNotFoundException(login));

        double sum = account.getOperationHistories().stream()
            .mapToDouble(OperationHistory::getAmount).sum();

        Message message = new Message();
        message.setLogin(account.getLogin());

        if(WRITE_OFF.equals(accountRequest.getOperation())
            && ((sum+accountRequest.getSum())<0 )){
            BalanceResponse balanceResponse = new BalanceResponse(0,
                DONT_ENOUGH_MONEY_MESSAGE);
            balanceResponse.setPaid(false);
            message.setMessage(DONT_ENOUGH_MONEY_MESSAGE);
            kafkaSender.send(message);
            return new ResponseEntity<>(balanceResponse, OK);
        }

        List<OperationHistory> operationHistories = account.getOperationHistories();
        OperationHistory operationHistory = new OperationHistory();
        operationHistory.setOperation(accountRequest.getOperation());
        operationHistory.setAmount(accountRequest.getSum());
        operationHistories.add(operationHistory);
        accountRepository.save(account);
        message.setMessage(FILL_UP.equals(accountRequest.getOperation())
                                    ? FILL_UP_BALANCE
                                    : ORDER_CREATED);
        kafkaSender.send(message);

        return new ResponseEntity<>(new BalanceResponse(0, "Операция произведена успешно"), OK);
    }
}
