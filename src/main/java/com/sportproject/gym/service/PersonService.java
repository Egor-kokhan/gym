package com.sportproject.gym.service;

import com.sportproject.gym.DTO.PersonDTO;
import com.sportproject.gym.entity.Person;

import java.util.List;

/**
 * @author Egor on 12.05.2020.
 */
public interface PersonService {
    List<PersonDTO> getAll();
    List<Person> getAllMoreOlder();

    void delete(long id);
    Person create(Person person);
    Person update(Person person);
}
