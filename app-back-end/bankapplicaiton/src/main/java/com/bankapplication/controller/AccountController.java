package com.bankapplication.controller;

import com.bankapplication.model.Accounts;
import com.bankapplication.repository.AccountsRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class AccountController {

    private AccountsRepository accountsRepository;

    public AccountController(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @PostMapping("/addAccount")
    public ResponseEntity addNewAccount(@RequestBody Accounts account) {
        ResponseEntity response = null;
        Accounts newAccount = accountsRepository.save(account);
        if (newAccount != null) {
            response = ResponseEntity.status(HttpStatus.CREATED)
                    .body("The account has been created successfully");
            return response;
        } else {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating new account for customer " + account.getCustomerId());
        }
        return response;
    }

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam long id) {
        Accounts accounts = accountsRepository.findByCustomerId(id);
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }
}
