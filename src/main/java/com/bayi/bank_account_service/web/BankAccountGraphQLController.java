package com.bayi.bank_account_service.web;

import com.bayi.bank_account_service.dto.BankAccountResponseDTO;
import com.bayi.bank_account_service.entities.BankAccount;
import com.bayi.bank_account_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById( id).orElseThrow(()->new RuntimeException(String.format("Bank account with id %s not found", id)));
    }
}
