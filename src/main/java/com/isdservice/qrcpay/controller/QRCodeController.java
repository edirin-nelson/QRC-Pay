package com.isdservice.qrcpay.controller;

import com.google.zxing.WriterException;
import com.isdservice.qrcpay.dto.request.MerchantDetailsRequest;
import com.isdservice.qrcpay.service.QRCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/qrcode")
@RequiredArgsConstructor
public class QRCodeController {
    private final QRCodeService qrCodeService;

    @PostMapping (value = "/generateQRCode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCode(@RequestBody MerchantDetailsRequest merchantDetails) throws IOException, WriterException {
        return new ResponseEntity<>(qrCodeService.generateQRCode(merchantDetails), HttpStatus.OK);
    }
}
