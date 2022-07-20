package com.example.gerenciarpessoas.controller;

import com.example.gerenciarpessoas.domain.Address;
import com.example.gerenciarpessoas.domain.Person;
import com.example.gerenciarpessoas.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/person")
public class PersonController {
    @Autowired
    private Service service;

    @PostMapping
    public Person createPerson(@RequestBody Person Person) {
        return service.savePerson(Person);
    }
    @GetMapping
    public List<Person> findAllPeople() {
        return service.findPeople();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        Person Person = service.findByPersonId(id);
        if (Person != null) {
            return ResponseEntity.ok(service.updatePerson(id, person));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findAllById(@PathVariable Long id) {
        Person Person = service.findByPersonId(id);
        if (Person != null) {
            return ResponseEntity.ok(Person);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{personId}/address")
    public Address createAddress(@PathVariable Long personId, @RequestBody Address address) {
        return service.saveAddress(personId, address);
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> findAllAddress() {
        return ResponseEntity.ok(service.findAddress());
    }
    @GetMapping("/{personId}/address")
    public ResponseEntity<List<Address>> findAddressId(@PathVariable Long personId)  {
        return ResponseEntity.ok(service.findAddressPersonId(personId));
    }



}
