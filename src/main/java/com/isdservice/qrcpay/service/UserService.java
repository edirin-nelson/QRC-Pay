package com.isdservice.qrcpay.service;


import com.isdservice.qrcpay.dto.request.RegisterRequest;
import com.isdservice.qrcpay.dto.response.RegisterResponse;
import com.isdservice.qrcpay.exceptions.UserAlreadyExistsException;
import com.isdservice.qrcpay.exceptions.UserNotFoundException;

public interface UserService {

    RegisterResponse registerUser(RegisterRequest request) throws UserAlreadyExistsException, UserNotFoundException;
}
