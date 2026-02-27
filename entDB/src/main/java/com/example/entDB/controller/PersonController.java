package com.example.entDB.controller;

import com.example.entDB.entity.Person;
import com.example.entDB.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> byCity(@RequestParam String city) {
        return repository.getPersonsByCity(city);
    }
}