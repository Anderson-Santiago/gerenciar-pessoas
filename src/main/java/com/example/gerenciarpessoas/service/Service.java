package com.example.gerenciarpessoas.service;

import com.example.gerenciarpessoas.domain.Address;
import com.example.gerenciarpessoas.domain.Person;
import com.example.gerenciarpessoas.repository.AddressRepository;
import com.example.gerenciarpessoas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    PersonRepository personrepository;
    @Autowired
    AddressRepository addressRepository;

    public List<Person> findPeople() {
        return personrepository.findAll();
    }

    public Person savePerson(Person person) {
        return personrepository.save(person);
    }

    public Person updatePerson(Long personId, Person person) {
        Person personToPersist = findByPersonId(personId);
        personToPersist.setName(person.getName());
        personToPersist.setBirthDate(person.getBirthDate());
        return personrepository.save(personToPersist);
    }

    public Person findByPersonId(Long personId) {
        Optional<Person> Person = personrepository.findById(personId);
        return Person.orElse(null);
    }






    public Address saveAddress(Long personId, Address address) {
        address.getPerson().setId(personId);
        Person person = findByPersonId(personId);
        person.setAddress(address);
        return addressRepository.save(address);
    }

    public List<Address> findAddress() {
        return addressRepository.findAll();
    }
    public List<Address> findAddressPersonId(Long personId) {
//        Person person = findByPersonId(personId);
//        Long idAddress = person.getAddress().getId();
        return addressRepository.findByPersonId(personId);
    }

}
