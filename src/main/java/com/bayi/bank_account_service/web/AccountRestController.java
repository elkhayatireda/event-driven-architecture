package com.bayi.bank_account_service.web;

import com.bayi.bank_account_service.entities.BankAccount;
import com.bayi.bank_account_service.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AccountRestController
{
    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Bank account not found")));
    }

    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount) {
       BankAccount account=bankAccountRepository.findById(id).orElse(null);
       if(bankAccount.getBalance() !=null) account.setBalance(bankAccount.getBalance());
       if(bankAccount.getCreatedAt() !=null) account.setCreatedAt(new Date());
       if(bankAccount.getType() !=null) account.setType(bankAccount.getType());
       if(bankAccount.getCurrency() !=null) account.setCurrency(bankAccount.getCurrency());
       return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
         bankAccountRepository.deleteById(id);
    }
}
