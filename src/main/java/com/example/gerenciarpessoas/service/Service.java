package com.example.gerenciarpessoas.service;

import com.example.gerenciarpessoas.dto.Address;
import com.example.gerenciarpessoas.dto.People;
import com.example.gerenciarpessoas.repository.AddressRepository;
import com.example.gerenciarpessoas.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    PeopleRepository peoplerepository;
    @Autowired
    AddressRepository addressRepository;
    public People savePeople(People people) {
        return peoplerepository.save(people);
    }
    public List<Address> findUsers() {
        return addressRepository.findAll();
    }


    public People updatePepole(People people){
        Address address = people.getAddress();
        addressRepository.save(address);
        return peoplerepository.save(people);
    }
}
