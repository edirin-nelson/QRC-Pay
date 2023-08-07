package com.isdservice.qrcpay.service;


import com.isdservice.qrcpay.dto.request.BankTransferRequest;
import com.isdservice.qrcpay.dto.request.QRCodeRequest;
import com.isdservice.qrcpay.dto.response.BankTransferResponse;
import com.isdservice.qrcpay.dto.response.QRcodeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TransferService {
    ResponseEntity<BankTransferResponse> bankTransfer(BankTransferRequest request);
    ResponseEntity<QRcodeResponse> verifyQRCodeDetails(QRCodeRequest data);
}
