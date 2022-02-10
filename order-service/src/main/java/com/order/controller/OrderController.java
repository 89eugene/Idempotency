package com.order.controller;

import static com.order.controller.Constant.X_REQUEST_ID;
import com.order.client.BillingClient;
import com.order.client.Constants;
import com.order.client.dto.BillingRequest;
import com.order.client.dto.BillingResponse;
import com.order.controller.dto.OrderRequest;
import com.order.models.Order;
import com.order.models.Product;
import com.order.models.Request;
import com.order.repository.OrderRepository;
import com.order.repository.RequestRepository;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private BillingClient billingClient;

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestParam(value = X_REQUEST_ID) String requestId, @RequestBody OrderRequest orderRequest) {
        Objects.requireNonNull(requestId);

        Optional<Request> hasRequest = requestRepository.findByRequestId(requestId);

        if(!hasRequest.isPresent()) {

            Order order = new Order();
            String login = orderRequest.getLogin();
            Product product = orderRequest.getProduct();
            order.setLogin(login);
            order.setProduct(product);

            BillingRequest billingRequest = new BillingRequest();
            billingRequest.setLogin(login);
            billingRequest.setSum(-product.getPrice());
            billingRequest.setOperation(Constants.WRITE_OFF);

            BillingResponse billingResponse = billingClient.executeOperation(billingRequest);
            order.setIsPaid(billingResponse.getPaid());

            Request request = new Request(requestId);
            request.setOrder(order);
            orderRepository.save(order);
            requestRepository.save(request);
            return ResponseEntity.ok().body(order);
        }
        return ResponseEntity.ok().body(hasRequest.get().getOrder());
    }

}