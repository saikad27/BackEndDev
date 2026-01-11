package com.example.__using_spring_data_jdbc_to_implement_data_persistence;


import com.example.__using_spring_data_jdbc_to_implement_data_persistence.dao.AccountRepository;
import com.example.__using_spring_data_jdbc_to_implement_data_persistence.exception.AccountNotFoundException;
import com.example.__using_spring_data_jdbc_to_implement_data_persistence.model.Account;
import com.example.__using_spring_data_jdbc_to_implement_data_persistence.service.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTest {

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    TransferService transferService;

    @Test
    public void moneyTransferHappyFlow(){
        //AccountRepository accountRepository = mock(AccountRepository.class);
        //TransferService transferService = new TransferService(accountRepository);

        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId())).willReturn(Optional.of(receiver));

        transferService.transferMoney(sender.getId(),receiver.getId(),new BigDecimal(100));

        verify(accountRepository).changeAmount(1,new BigDecimal(900));
        verify(accountRepository).changeAmount(2,new BigDecimal(1100));

    }

    @Test
    public void moneyTransferExceptionFlow(){
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(1L)).willReturn(Optional.of(sender));
        given(accountRepository.findById(2L)).willReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class,()->transferService.transferMoney(1,2,new BigDecimal(200)));

        verify(accountRepository,never()).changeAmount(anyLong(),any());
    }
}
