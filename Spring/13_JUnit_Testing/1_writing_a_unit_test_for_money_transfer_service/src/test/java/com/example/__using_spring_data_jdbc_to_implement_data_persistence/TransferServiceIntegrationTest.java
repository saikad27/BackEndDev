package com.example.__using_spring_data_jdbc_to_implement_data_persistence;

import com.example.__using_spring_data_jdbc_to_implement_data_persistence.dao.AccountRepository;
import com.example.__using_spring_data_jdbc_to_implement_data_persistence.model.Account;
import com.example.__using_spring_data_jdbc_to_implement_data_persistence.service.TransferService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
public class TransferServiceIntegrationTest {
    @MockitoBean
    private AccountRepository accountRepository;

    @Autowired
    private TransferService transferService;

    @Test
    void transferServiceTransferAmountTest(){
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));
        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));
        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(receiver));
        transferService.transferMoney(1,2,new BigDecimal(200));

        verify(accountRepository).changeAmount(1L,new BigDecimal(800));
        verify(accountRepository).changeAmount(2L,new BigDecimal(1200));
    }
}
