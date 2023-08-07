package com.isdservice.qrcpay.repository;


import com.isdservice.qrcpay.entity.User;
import com.isdservice.qrcpay.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    Wallet findByAccountNumber(String accountNumber);
    Wallet findByUser(User user);
}
