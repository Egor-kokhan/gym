package com.sportproject.gym.controller;

import com.sportproject.gym.DTO.PersonDTO;
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
    public ResponseEntity<List<PersonDTO>> getAll() {
        List<PersonDTO> persons = service.getAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> get(@PathVariable long id) {
        PersonDTO person = service.get(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO person) {
        PersonDTO newPerson = service.create(person);
        return ResponseEntity.ok(newPerson);
    }

    @PutMapping
    public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO person) {
        PersonDTO newPerson = service.update(person);
        return ResponseEntity.ok(newPerson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
