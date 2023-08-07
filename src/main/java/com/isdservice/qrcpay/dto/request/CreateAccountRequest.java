package com.isdservice.qrcpay.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAccountRequest {

    private String email;
    private boolean is_permanent;
    private String bvn;
    private String tx_ref;
    private String phoneNumber;
    private String firstname;
    private String lastname;
    private String narration;
    private int amount;

}
