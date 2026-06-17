package com.wj.wfinance.infra.persistence.entity.account;

import jakarta.persistence.Embeddable;

@Embeddable
public class AddressEmbeddable {

    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String uf;
    private String cep;
}
