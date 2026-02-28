package com.example.entDB.controller;

import com.example.entDB.entity.Person;
import com.example.entDB.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/by-city")
    public List<Person> byCity(@RequestParam String city) {
        return repository.findByCityOfLiving(city);
    }

    @GetMapping("/younger-than")
    public List<Person> youngerThan(@RequestParam Integer age) {
        return repository.findByAgeLessThanOrderByAgeAsc(age);
    }

    // новое: /persons/by-name-surname?name=Ivan&surname=Petrov
    @GetMapping("/by-name-surname")
    public Optional<Person> byNameSurname(@RequestParam String name,
                                          @RequestParam String surname) {
        return repository.findFirstByNameAndSurname(name, surname);
    }

    // CRUD (если хочешь показать явно, хотя JpaRepository уже умеет)
    @GetMapping
    public List<Person> all() {
        return repository.findAll();
    }
}