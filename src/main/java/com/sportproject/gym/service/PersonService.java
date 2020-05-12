package com.sportproject.gym.service;

import com.sportproject.gym.entity.Person;

import java.util.List;

/**
 * @author Egor on 12.05.2020.
 */
public interface PersonService {
    List<Person> getAll();
    List<Person> getAllMoreOlder();
}
