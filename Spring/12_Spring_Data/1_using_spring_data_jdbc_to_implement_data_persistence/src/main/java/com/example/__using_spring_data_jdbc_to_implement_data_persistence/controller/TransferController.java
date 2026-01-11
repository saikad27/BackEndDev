package com.example.__using_spring_data_jdbc_to_implement_data_persistence.controller;

import com.example.__using_spring_data_jdbc_to_implement_data_persistence.dto.TransferRequest;
import com.example.__using_spring_data_jdbc_to_implement_data_persistence.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.__using_spring_data_jdbc_to_implement_data_persistence.service.TransferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TransferController {
    private TransferService transferService;
    public TransferController(TransferService transferService){
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest transferRequest){
        transferService.transferMoney(transferRequest.getSenderId(),transferRequest.getReceiverId(),transferRequest.getAmount());
    }

    @GetMapping("/account")
    public Iterable<Account> getAccounts(@RequestParam(required=false) String name){
        if(name==null){
            return transferService.getAllAccounts();
        }else{
            return transferService.getAccountsByName(name);
        }
    }
}
