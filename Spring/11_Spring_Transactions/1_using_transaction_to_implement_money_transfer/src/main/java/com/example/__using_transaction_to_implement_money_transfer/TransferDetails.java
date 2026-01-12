package com.example.__using_transaction_to_implement_money_transfer;

import java.math.BigDecimal;

public class TransferDetails {
    private int senderId;
    private int receiverId;
    private BigDecimal amount;

    public TransferDetails(int senderId, int receiverId, BigDecimal amount) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
    }

    public int getSenderId() {
        return senderId;
    }



    public int getReceiverId() {
        return receiverId;
    }



    public BigDecimal getAmount() {
        return amount;
    }


}
