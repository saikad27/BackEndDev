package com.example.__using_transaction_to_implement_money_transfer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransferService {
    private AccountRepository accountRepo;
    TransferService(AccountRepository accountRepo){
        this.accountRepo = accountRepo;
    }

    @Transactional
    public void transfer(int senderId,int receiverId,BigDecimal amount){
        Account sender = accountRepo.getAccount(senderId);
        Account receiver = accountRepo.getAccount(receiverId);

        BigDecimal senderAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverAmount = receiver.getAmount().add(amount);

        accountRepo.changeAmount(senderAmount,sender.getId());  //Withdrawing from sender's account
        //throw new RuntimeException();
        accountRepo.changeAmount(receiverAmount,receiver.getId());//Depositing to receiver's account

    }
}
