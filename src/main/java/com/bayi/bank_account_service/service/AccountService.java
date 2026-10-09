package com.bayi.bank_account_service.service;

import com.bayi.bank_account_service.dto.BankAccountRequestDTO;
import com.bayi.bank_account_service.dto.BankAccountResponseDTO;


public interface AccountService {
     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

     BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
