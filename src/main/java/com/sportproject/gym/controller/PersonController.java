package com.sportproject.gym.controller;

import com.sportproject.gym.entity.Person;
import com.sportproject.gym.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Egor on 12.05.2020.
 */
@RestController
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getPerson() {
        List<Person> persons = service.getAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping(value = "/age+5")
    public ResponseEntity<List<Person>> getMoreOlderPerson() {
        List<Person> persons = service.getAllMoreOlder();
        return ResponseEntity.ok(persons);
    }

}
