package com.example.gerenciarpessoas.controller;

import com.example.gerenciarpessoas.entity.Address;
import com.example.gerenciarpessoas.entity.People;
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

@RestController
@RequestMapping(value = "/api")
public class PeopleController {
    @Autowired
    private Service service;

    @PostMapping
    public People createPeople(@RequestBody People people) {
        return service.savePeople(people);
    }

    @PutMapping
    public People updatePeople(@RequestBody People people) {
        return service.updatePepole(people);
    }

    @GetMapping("{id}")
    public ResponseEntity<People> findAllById(@PathVariable Long id) {
        People people = service.findByPeopleId(id);
        if (people != null) {
            return ResponseEntity.ok(people);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/people")
    public ResponseEntity<List<People>> findAllPeople() {
        return ResponseEntity.ok(service.findPeople());
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> findAllAddress() {
        return ResponseEntity.ok(service.findAddress());
    }

}
