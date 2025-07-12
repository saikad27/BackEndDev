package com.example.__a_backend_app_called_payment_service;

import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.UUID;
import org.springframework.http.HttpStatus;

@Controller
public class PaymentController {

    private final Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping("/payment")
    @ResponseBody
    public ResponseEntity<Payment> createPayment(@RequestHeader String requestId,@RequestBody Payment payment){
        logger.info("Received request with Id : "+requestId+", Payment Amount : "+payment.getAmount());
        payment.setId(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.OK).header("Request Id",requestId).body(payment);
    }


}
