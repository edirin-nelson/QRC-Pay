package com.isdservice.qrcpay.repository;



import com.isdservice.qrcpay.entity.JwtToken;
import com.isdservice.qrcpay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JwtTokenRepository extends JpaRepository<JwtToken, Integer> {
    Optional<JwtToken> findByToken(String token);

    List<JwtToken> findTokenByUserAndExpiredIsFalseAndRevokedIsFalse(User user);
}
