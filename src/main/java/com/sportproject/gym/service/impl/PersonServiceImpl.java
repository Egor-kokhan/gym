package com.sportproject.gym.service.impl;

import com.sportproject.gym.entity.Person;
import com.sportproject.gym.repository.PersonRepository;
import com.sportproject.gym.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Egor on 12.05.2020.
 */
@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Person> getAllMoreOlder() {
        List<Person> persons = repository.findAll();
        for (Person person : persons) {
            person.setAge(person.getAge()+5);
        }

        return persons;
    }

}
