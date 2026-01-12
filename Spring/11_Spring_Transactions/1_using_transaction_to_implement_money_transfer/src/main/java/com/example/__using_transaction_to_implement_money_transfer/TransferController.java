package com.example.__using_transaction_to_implement_money_transfer;


import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private TransferService transferService;
    private AccountRepository accountRepo;

    public TransferController(TransferService transferService,AccountRepository accountRepo){
        this.transferService = transferService;
        this.accountRepo = accountRepo;
    }

    @PostMapping("/transfer")
    public void transferAction(@RequestBody TransferDetails transferDetails){
        transferService.transfer(transferDetails.getSenderId(),transferDetails.getReceiverId(),transferDetails.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> transfer(){
        return accountRepo.getAllRecords();
    }
}
