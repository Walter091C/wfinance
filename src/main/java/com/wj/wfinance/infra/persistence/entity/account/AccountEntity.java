package com.wj.wfinance.infra.persistence.entity.account;

import com.wj.wfinance.domain.enums.AccountTypeEnum;
import com.wj.wfinance.utils.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class AccountEntity extends BaseEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    private String branch;

    @Column(name = "check_digit", nullable = false, unique = true)
    private String checkDigit;

    @Column(name = "account_type", nullable = false)
    private AccountTypeEnum accountTypeEnum;

    private BigDecimal balance;

    @Column(name = "active")
    private boolean active = true;

    @Column(name = "opening_date", nullable = false)
    private LocalDate openingDate = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_holder_id", nullable = false)
    private AccountHolderEntity accountHolder;
}
