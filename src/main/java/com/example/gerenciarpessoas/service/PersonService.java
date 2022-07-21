package com.example.gerenciarpessoas.service;

import com.example.gerenciarpessoas.domain.Person;
import com.example.gerenciarpessoas.exception.LoginNotExistsException;
import com.example.gerenciarpessoas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personrepository;
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

    public void existsByIdPerson(Long personId) {
        boolean personExist = personrepository.existsById(personId);
        if (!personExist) {
            throw new LoginNotExistsException();
        }
    }

}
