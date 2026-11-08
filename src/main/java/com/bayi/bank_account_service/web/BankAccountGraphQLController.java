package com.bayi.bank_account_service.web;

import com.bayi.bank_account_service.dto.BankAccountRequestDTO;
import com.bayi.bank_account_service.dto.BankAccountResponseDTO;
import com.bayi.bank_account_service.entities.BankAccount;
import com.bayi.bank_account_service.entities.Customer;
import com.bayi.bank_account_service.repositories.BankAccountRepository;
import com.bayi.bank_account_service.repositories.CustomerRepository;
import com.bayi.bank_account_service.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Handles GraphQL queries and mutations for bank accounts and customers.
 */
@Controller
public class BankAccountGraphQLController {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;

    /** Returns all bank accounts. */
    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }

    /** Finds a bank account by its identifier. */
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById( id).orElseThrow(()->new RuntimeException(String.format("Bank account with id %s not found", id)));
    }

    /** Creates a bank account from the supplied input. */
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    /** Updates a bank account using the supplied input. */
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id,bankAccount);
    }

    /** Deletes the bank account with the requested identifier. */
    @MutationMapping
    public Boolean deleteAccount(@Argument String id) {
         bankAccountRepository.deleteById(id);
         return true;
    }

    /** Returns all customers. */
    @QueryMapping
    public List<Customer> customers() {
        return customerRepository.findAll();
    }
}

// The GraphQL schema declares the account input type.
