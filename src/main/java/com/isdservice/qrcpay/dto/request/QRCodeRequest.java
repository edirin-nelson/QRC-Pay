package com.isdservice.qrcpay.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QRCodeRequest {

    private String bankName;
    private String accountNumber;
}
