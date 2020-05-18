package com.sportproject.gym.controller;

import com.sportproject.gym.entity.Person;
import com.sportproject.gym.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person newPerson = service.create(person);
        return ResponseEntity.ok(newPerson);
    }

    @PutMapping
    public ResponseEntity<Person> update(@RequestBody Person person) {
        Person newPerson = service.update(person);
        return ResponseEntity.ok(newPerson);
    }
}
