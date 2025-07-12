package com.sai.__managing_endpoint_exceptions;


import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(){
        try{
            PaymentDetails paymentDetail = paymentService.processPayment();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetail);
        }catch(NotEnoughMoneyException e){
            ErrorDetails ed = new ErrorDetails();
            ed.setErrorMessage("Not enough money to make the payment");
            return ResponseEntity.badRequest().body(ed);
        }
    }

}
