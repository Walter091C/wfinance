package com.wj.wfinance.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adress {

    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String uf;
    private String cep;
}
