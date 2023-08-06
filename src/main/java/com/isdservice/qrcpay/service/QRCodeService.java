package com.isdservice.qrcpay.service;

import com.google.zxing.WriterException;
import com.isdservice.qrcpay.dto.request.MerchantDetailsRequest;

import java.io.IOException;

public interface QRCodeService {
    byte[] generateQRCode(MerchantDetailsRequest merchantDetails) throws IOException, WriterException;
}
