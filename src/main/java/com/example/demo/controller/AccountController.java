package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;

    @PostMapping("/data")
    public ResponseEntity<Account> syncData(@Valid @RequestBody Account account) {
        try {
            Account savedAccount = accountRepository.save(account);
            accountService.saveAccountData();
            return ResponseEntity.ok(savedAccount); // Return the saved account as JSON
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/data")
    public ResponseEntity<List<Account>> getSyncData() {
        try {
            List<Account> account = accountRepository.findAll();
            return ResponseEntity.ok(account); // Return the account as JSON
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("data/{id}")
    public ResponseEntity<Account> putSyncData(@PathVariable(value = "id") String id,
            @Valid @RequestBody Account accountDetails) {
        // TODO: process PUT request
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Account account = optionalAccount.get();
        account.setName(accountDetails.getName());
        account.setType(accountDetails.getType());
        account.setIndustry(accountDetails.getIndustry());
        account.setPhone(accountDetails.getPhone());
        account.setWebsite(accountDetails.getWebsite());

        Account updateAccount = accountRepository.save(account);
        return ResponseEntity.ok(updateAccount);
    }

    // New: DELETE endpoint to remove an account by id
    @DeleteMapping("/data/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") String id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        accountRepository.delete(optionalAccount.get());
        return ResponseEntity.noContent().build();
    }

}
