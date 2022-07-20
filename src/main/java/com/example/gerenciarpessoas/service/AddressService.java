package com.example.gerenciarpessoas.service;

import com.example.gerenciarpessoas.domain.Address;
import com.example.gerenciarpessoas.domain.Person;
import com.example.gerenciarpessoas.exception.LoginNotExistsException;
import com.example.gerenciarpessoas.repository.AddressRepository;
import com.example.gerenciarpessoas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    PersonService personService;

    public Address saveAddress(Long personId, Address address) {
        personService.existsByIdPerson(personId);
        setMainAddress(personId, address);
        address.getPerson().setId(personId);
        Person person = personService.findByPersonId(personId);
        person.setAddress(address);
        return addressRepository.save(address);
    }

    public List<Address> findAddress() {
        return addressRepository.findAll();
    }

    public List<Address> findAddressPersonId(Long personId) {
        personService.existsByIdPerson(personId);
        return addressRepository.findByPersonId(personId);
    }

    public void setMainAddress(Long personId, Address address) {
        List<Address> exist = addressRepository.findByPersonId(personId);
        if (address.getMainAddress()) {
            exist.forEach(it -> {
                        it.setMainAddress(false);
                        addressRepository.save(it);
                    }
            );
        }
    }
}
