package com.example.gerenciarpessoas.controller;

import com.example.gerenciarpessoas.dto.Address;
import com.example.gerenciarpessoas.dto.People;
import com.example.gerenciarpessoas.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public People updatePeople(@RequestBody People people){
        return service.updatePepole(people);
    }
    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok(service.findUsers());
    }
//    @PostMapping("/address")
//    public Address createPeople(@RequestBody Address address) {
//        return service.saveAddress(address);
//    }
//
}
