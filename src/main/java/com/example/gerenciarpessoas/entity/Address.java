package com.example.gerenciarpessoas.entity;

import com.example.gerenciarpessoas.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "tb_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipCode;
    private Integer number;
    private String city;
    private Boolean mainAddress;
    public static Address fromDTO(AddressDTO dto){
        Address entity = new Address();
        if(dto.getId() != null){
            entity.setId(dto.getId());
        }
        entity.setId(dto.getId());
        entity.setStreet(dto.getStreet());
        entity.setZipCode(dto.getZipCode());
        entity.setNumber(dto.getNumber());
        entity.setCity(dto.getCity());
        entity.setMainAddress(dto.getMainAddress());

        return entity;
    }
}
