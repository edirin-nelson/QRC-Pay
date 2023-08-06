package com.isdservice.qrcpay.repository;

import com.isdservice.qrcpay.entity.MerchantDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantDetailsRepo extends JpaRepository<MerchantDetails, Long> {
}
