package com.bankapplication.controller;

import com.bankapplication.model.Loans;
import com.bankapplication.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanRepository loanRepository;


    @PostMapping("/addLoan")
    public ResponseEntity addNewLoan(@RequestBody Loans loan) {
        ResponseEntity response = null;
        Loans newLoan = loanRepository.save(loan);
        if (newLoan != null) {
            response = ResponseEntity.status(HttpStatus.CREATED)
                    .body("The loan has been added successfully");
        } else {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding the loan to the database");
        }
        return response;
    }

    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam int id) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }
}
