package com.bayi.bank_account_service.dto;

import com.bayi.bank_account_service.enums.AccountType;
import lombok.*;


import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
