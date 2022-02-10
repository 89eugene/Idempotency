package com.person.controller;

import com.person.client.BillingClient;
import com.person.client.dto.BillingCreateAccountRequest;
import com.person.client.dto.BillingResponce;
import com.person.controller.dto.UserRequest;
import com.person.controller.dto.UserResponse;
import com.person.exception.UserNotFoundException;
import com.person.models.User;
import com.person.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/person")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BillingClient billingClient;

    @PostMapping("/register")
    public ResponseEntity<User>  userAdd(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setLogin(userRequest.getLogin());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());

        BillingResponce billingResponce = billingClient.createAccount(new BillingCreateAccountRequest((userRequest.getLogin())));
        if(!billingResponce.isSuccess()){
            return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(user);
        }

        userRepository.save(user);
        return  ResponseEntity.ok().body(user);
    }

    @GetMapping("/user/{userSessionId}")
    public ResponseEntity<User>  userDetails(@PathVariable(value = "userSessionId") long id) {
        final BodyBuilder response = ResponseEntity.ok();
        User user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
        return  response.body(user);
    }

    @PutMapping("/user/{userSessionId}")
    public ResponseEntity<UserResponse> userUpdate(@PathVariable(value = "userSessionId") long id,
                             @RequestBody UserRequest userRequest) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
        if (user != null) {
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            user.setEmail(userRequest.getEmail());
            user.setPhone(userRequest.getPhone());
            userRepository.save(user);
        }
        return new ResponseEntity<>(new UserResponse(0, "Пользователь обновлен"), OK);
    }

    @DeleteMapping("/user/{userSessionId}")
    public ResponseEntity<UserResponse> userDelete(@PathVariable(value = "userSessionId") long id) {

        userRepository.deleteById(id);
        return new ResponseEntity<>(new UserResponse(0, "Пользователь удален"), NO_CONTENT);
    }
}
