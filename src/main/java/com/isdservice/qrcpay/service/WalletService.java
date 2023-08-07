package com.isdservice.qrcpay.service;


import com.isdservice.qrcpay.entity.Wallet;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface WalletService {
    ResponseEntity<Wallet> getWallet();
}
