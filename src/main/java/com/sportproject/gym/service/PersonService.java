package com.sportproject.gym.service;

import com.sportproject.gym.DTO.PersonDTO;
import com.sportproject.gym.entity.Person;

import java.util.List;

/**
 * @author Egor on 12.05.2020.
 */
public interface PersonService {
    List<PersonDTO>  getAll();

    void delete(long id);
    PersonDTO create(PersonDTO personDTO);
    PersonDTO update(PersonDTO personDTO);
}
