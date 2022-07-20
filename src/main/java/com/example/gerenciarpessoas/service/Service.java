package com.example.gerenciarpessoas.service;

import com.example.gerenciarpessoas.domain.Address;
import com.example.gerenciarpessoas.domain.Person;
import com.example.gerenciarpessoas.exception.LoginNotExistsException;
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
        existsByIdPerson(personId);
        Person personToPersist = findByPersonId(personId);
        personToPersist.setName(person.getName());
        personToPersist.setBirthDate(person.getBirthDate());
        return personrepository.save(personToPersist);
    }

    public Person findByPersonId(Long personId) {
        existsByIdPerson(personId);
        Optional<Person> person = personrepository.findById(personId);
        return person.orElse(null);
    }

    public Address saveAddress(Long personId, Address address) {
        existsByIdPerson(personId);
        setMainAddress(personId, address);
        address.getPerson().setId(personId);
        Person person = findByPersonId(personId);
        person.setAddress(address);
        return addressRepository.save(address);
    }

    public List<Address> findAddress() {
        return addressRepository.findAll();
    }

    public List<Address> findAddressPersonId(Long personId) {
        existsByIdPerson(personId);
        return addressRepository.findByPersonId(personId);
    }

    public void existsByIdPerson(Long personId) {
        boolean personExist = personrepository.existsById(personId);
        if (!personExist) {
            throw new LoginNotExistsException();
        }
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
