package com.wj.wfinance.infra.persistence.entity.account;

import com.wj.wfinance.domain.entity.Adress;
import com.wj.wfinance.domain.entity.account.Account;
import com.wj.wfinance.infra.persistence.entity.UserEntity;
import com.wj.wfinance.utils.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account_holder")
public class AccountHolderEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private AddressEmbeddable address;

    private String phoneNumber;
    private String cpf;
    private String rg;

    @OneToMany(
            mappedBy = "accountHolder",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<AccountEntity> accounts = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserEntity user;

}
