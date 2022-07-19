package com.example.gerenciarpessoas.dto;

import com.example.gerenciarpessoas.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AddressDTO{
    private Long id;
    private String street;
    private String zipCode;
    private Integer number;
    private String city;
    private Boolean mainAddress;

    public static AddressDTO fromEntity(Address entity) {
        AddressDTO dto = new AddressDTO();
        dto.setId(entity.getId());
        dto.setId(entity.getId());
        dto.setStreet(entity.getStreet());
        dto.setZipCode(entity.getZipCode());
        dto.setNumber(entity.getNumber());
        dto.setCity(entity.getCity());
        dto.setMainAddress(entity.getMainAddress());


        return dto;
    }
}
