package com.example.gerenciarpessoas.domain;

public class AddressGenerator {
    public static Address buildCreateAddress() {
        return Address.builder()
                .street("Rua da Paz")
                .zipCode("40330370")
                .number(81)
                .city("Salvador")
                .mainAddress(true)
                .person(Person.builder().build())
                .build();
    }
}
