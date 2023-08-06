package com.isdservice.qrcpay.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDetailsResponse {
    private String bankName;
    private String accountNumber;
    private String merchantName;
}
