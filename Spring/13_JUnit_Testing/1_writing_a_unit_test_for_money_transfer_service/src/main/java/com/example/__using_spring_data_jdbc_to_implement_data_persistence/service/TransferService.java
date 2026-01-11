package com.example.__using_spring_data_jdbc_to_implement_data_persistence.service;

import com.example.__using_spring_data_jdbc_to_implement_data_persistence.dao.AccountRepository;
import com.example.__using_spring_data_jdbc_to_implement_data_persistence.exception.AccountNotFoundException;
import com.example.__using_spring_data_jdbc_to_implement_data_persistence.model.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long senderId, long receiverId, BigDecimal amount){
        Account sender = accountRepository.findById(senderId).orElseThrow(() -> new AccountNotFoundException());
        Account receiver = accountRepository.findById(receiverId).orElseThrow(() -> new AccountNotFoundException());
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
        accountRepository.changeAmount(senderId,senderNewAmount);
        accountRepository.changeAmount(receiverId,receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public List<Account> getAccountsByName(String name){
        return accountRepository.findAccountsByName(name);
    }
}
