package com.example.gerenciarpessoas.domain;

import java.time.LocalDate;

public class PersonGenerator {
    public static Person buildCreatePerson() {
        return Person.builder()
                .id(1L)
                .name("Anderson Santiago")
                .birthDate(LocalDate.parse("2000-01-25"))
                .address(Address.builder().build())
                .build();
    }

    public static Person buildUpdatePerson() {
        return Person.builder()
                .name("Santiago Anderson")
                .birthDate(LocalDate.parse("1999-12-20"))
                .address(AddressGenerator.buildCreateAddress())
                .build();
    }
}
