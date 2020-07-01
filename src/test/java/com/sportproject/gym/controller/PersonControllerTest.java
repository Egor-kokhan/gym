package com.sportproject.gym.controller;

import com.sportproject.gym.DTO.PersonDTO;
import com.sportproject.gym.entity.Person;
import com.sportproject.gym.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Egor on 01.07.2020.
 */

@SpringBootTest
@TestPropertySource("/application.properties")
@Sql(value = {"/create-person-before.sql"})
class PersonControllerTest {

    @Autowired
    private PersonController controller;

    @Autowired
    private PersonRepository repository;

    @Test
    void getAll() throws Exception {
        ResponseEntity<List<PersonDTO>> responseEntity = controller.getAll();
        List<PersonDTO> persons = responseEntity.getBody();
        PersonDTO egor = new PersonDTO();
        egor.setId(1);
        egor.setFirstName("Егор");
        egor.setLastName("Кохан");
        egor.setAge(25);

        PersonDTO sasha = new PersonDTO();
        sasha.setId(2);
        sasha.setFirstName("Саша");
        sasha.setLastName("Мягков");
        sasha.setAge(24);

        assertNotNull(persons);
        assertTrue(persons.contains(egor));
        assertTrue(persons.contains(sasha));
    }

    @Test
    void create() throws Exception {
        PersonDTO personForSave = new PersonDTO();
        personForSave.setFirstName("Артур");
        personForSave.setLastName("Мартиросян");
        personForSave.setAge(45);

        ResponseEntity<PersonDTO> responseEntity = controller.create(personForSave);
        PersonDTO savedPerson = responseEntity.getBody();

        assertNotNull(savedPerson);
        assertNotEquals(0, savedPerson.getId());
        assertEquals(personForSave.getFirstName(), savedPerson.getFirstName());
        assertEquals(personForSave.getLastName(), savedPerson.getLastName());
        assertEquals(personForSave.getAge(), savedPerson.getAge());
    }

    @Test
    void update() throws Exception {
        PersonDTO personForUpdate = new PersonDTO();
        personForUpdate.setId(1);
        personForUpdate.setFirstName("Новый Егор");
        personForUpdate.setLastName("Не Кохан");
        personForUpdate.setAge(20);

        ResponseEntity<PersonDTO> responseEntity = controller.update(personForUpdate);
        PersonDTO updatedPerson = responseEntity.getBody();

        assertNotNull(updatedPerson);
        assertEquals(personForUpdate.getFirstName(), updatedPerson.getFirstName());
        assertEquals(personForUpdate.getLastName(), updatedPerson.getLastName());
        assertEquals(personForUpdate.getAge(), updatedPerson.getAge());
    }


    @Test
    void delete() throws Exception {
        int sizeBeforeDeleting = repository.findAll().size();
        ResponseEntity<?> delete = controller.delete(1);
        int sizeAfterDeleting = repository.findAll().size();

        assertTrue(delete.getStatusCode().is2xxSuccessful());
        assertTrue(sizeBeforeDeleting > sizeAfterDeleting);
    }

}