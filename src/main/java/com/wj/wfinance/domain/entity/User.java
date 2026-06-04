package com.wj.wfinance.domain.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public sealed class User permits AccountHolder {

    private Long id;
    private String name;
    private String email;
    private String password;
}
