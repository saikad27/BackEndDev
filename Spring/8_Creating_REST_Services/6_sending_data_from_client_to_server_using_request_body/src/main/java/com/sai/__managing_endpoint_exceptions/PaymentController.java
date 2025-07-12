package com.sai.__managing_endpoint_exceptions;


import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class PaymentController {

    private static final Logger logger = Logger.getLogger(PaymentController.class.getName());



    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetail){
        logger.info("Received payment : "+paymentDetail.getAmount());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetail);
    }

}
