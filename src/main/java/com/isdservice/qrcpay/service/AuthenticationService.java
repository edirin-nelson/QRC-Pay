package com.isdservice.qrcpay.service;


import com.isdservice.qrcpay.dto.request.LoginRequest;
import com.isdservice.qrcpay.dto.response.LoginResponse;
import com.isdservice.qrcpay.exceptions.UserAccountDisabledException;
import com.isdservice.qrcpay.exceptions.UserNotFoundException;

public interface AuthenticationService  {

    LoginResponse authenticateUser(LoginRequest request) throws UserNotFoundException, UserAccountDisabledException;
}
