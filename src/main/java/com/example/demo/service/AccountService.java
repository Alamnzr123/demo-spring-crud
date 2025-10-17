package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import jakarta.validation.Valid;
import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    public @Valid Object saveAccountData() {
        try {
            logger.info("Data Saved");
        }
        catch (Exception e){
            logger.error("Error save to database", e);
            throw new RuntimeException("Failed to connect to database");
        }
        return logger;
    }
}
