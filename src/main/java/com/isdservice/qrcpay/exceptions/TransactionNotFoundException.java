package com.isdservice.qrcpay.exceptions;

import lombok.Data;

@Data
public class TransactionNotFoundException extends RuntimeException{
    public TransactionNotFoundException(String message){
        super(message);
    }
}
