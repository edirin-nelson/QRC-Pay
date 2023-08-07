package com.isdservice.qrcpay.service.serviceImpl;


import com.isdservice.qrcpay.dto.request.CreateAccountRequest;
import com.isdservice.qrcpay.dto.request.RegisterRequest;
import com.isdservice.qrcpay.dto.response.CreateAccountResponse;
import com.isdservice.qrcpay.dto.response.RegisterResponse;
import com.isdservice.qrcpay.entity.User;
import com.isdservice.qrcpay.entity.Wallet;
import com.isdservice.qrcpay.enums.Role;
import com.isdservice.qrcpay.exceptions.UserAlreadyExistsException;
import com.isdservice.qrcpay.flutterAPI.AccountCreationData;
import com.isdservice.qrcpay.flutterAPI.FlutterURLs;
import com.isdservice.qrcpay.flutterAPI.RestTemplateUtils;
import com.isdservice.qrcpay.repository.UserRepository;
import com.isdservice.qrcpay.repository.WalletRepository;
import com.isdservice.qrcpay.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RestTemplate restTemplate;
    private final RestTemplateUtils header;
    private final WalletRepository walletRepo;

    @Override
    public RegisterResponse registerUser(RegisterRequest request) throws UserAlreadyExistsException {

        Optional<User> user = userRepository.findByEmail(request.getEmail());

        if(user.isPresent()){
            throw new UserAlreadyExistsException("User with email "+request.getEmail() + " already exists.");
        }

        User newUser = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .enabled(false)
                .bvn(request.getBvn())
                .role(Role.USER)
                .pin(passwordEncoder.encode(request.getPin()))
                .build();

        User u = userRepository.save(newUser);
        createAccount(u);

        RegisterResponse response = new RegisterResponse();
        response.setEmail(u.getEmail());
        response.setLastName(u.getLastName());
        response.setFirstName(u.getFirstName());

        return response;
    }

    private void createAccount( User user){
       var accountCreation = CreateAccountRequest.builder()
               .email(user.getEmail())
               .is_permanent(true)
               .bvn(user.getBvn())
               .tx_ref("VA12")
               .phoneNumber(user.getPhoneNumber())
               .firstname(user.getFirstName())
               .lastname(user.getLastName())
               .amount(5000)
               .narration("account creation for " +user.getFirstName() +" "+user.getLastName())
               .build();


        HttpEntity<CreateAccountRequest> request = new HttpEntity<>(accountCreation, header.getHeaders());
        String url = FlutterURLs.BASE_URL + FlutterURLs.CREATE_ACCOUNT;

        ResponseEntity<CreateAccountResponse> response = restTemplate.exchange(url, HttpMethod.POST, request, CreateAccountResponse.class );
        CreateAccountResponse resp = response.getBody();

        if(resp.getStatus().equals("success") && resp.getData().getResponse_code().equals("02")) {
            log.info(resp.toString());
            createWallet(resp.getData(), user.getEmail());
        }

    }

    private void createWallet(AccountCreationData resp, String email) {
        User newUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        log.info("newUser" + newUser.toString());

        var newWallet = Wallet.builder()
                .accountBalance(resp.getAmount())
                .accountNumber(resp.getAccount_number())
                .bankName(resp.getBank_name())
                .created_at(resp.getCreated_at())
                .expiry_date(resp.getExpiry_date())
                .flw_ref(resp.getFlw_ref())
                .frequency(resp.getFrequency())
                .order_ref(resp.getOrder_ref())
                .user(newUser)
                .build();
        log.info("wallet" + newWallet.toString());

        walletRepo.save(newWallet);
        newUser.setWallet(newWallet);
        userRepository.save(newUser);
    }
}
