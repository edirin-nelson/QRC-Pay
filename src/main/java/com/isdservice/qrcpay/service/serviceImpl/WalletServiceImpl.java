package com.isdservice.qrcpay.service.serviceImpl;


import com.isdservice.qrcpay.entity.User;
import com.isdservice.qrcpay.entity.Wallet;
import com.isdservice.qrcpay.repository.UserRepository;
import com.isdservice.qrcpay.repository.WalletRepository;
import com.isdservice.qrcpay.service.WalletService;
import com.isdservice.qrcpay.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepo;
    private final UserRepository userRepo;
    private final SecurityUtils securityUtils;

    @Override
    public ResponseEntity<Wallet> getWallet() {

        String email = securityUtils.getCurrentUserDetails().getUsername();
        User user = userRepo.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));

        return ResponseEntity.ok(walletRepo.findByUser(user)) ;
    }
}
