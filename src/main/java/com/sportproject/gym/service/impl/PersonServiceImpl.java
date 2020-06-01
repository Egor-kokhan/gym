package com.sportproject.gym.service.impl;

import com.sportproject.gym.DTO.PersonDTO;
import com.sportproject.gym.entity.Person;
import com.sportproject.gym.mapper.PersonMapper;
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
    private final PersonMapper personMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository repository, PersonMapper personMapper) {
        this.repository = repository;
        this.personMapper = personMapper;
    }

    @Override
    public PersonDTO getAll() {
        return personMapper.personToPersonDto(repository.findAll().get(0));
    }

    @Override
    public List<Person> getAllMoreOlder() {
        List<Person> persons = repository.findAll();
        for (Person person : persons) {
            person.setAge(person.getAge() + 5);
        }

        return persons;
    }

    @Override
    public void delete(long id) {
        if (!repository.existsById(id)) {
            System.out.println("Запись не найдена");
        } else {
            repository.deleteById(id);
        }
    }

    @Override
    public Person create(Person person) {
        repository.save(person);
        return person;
    }

    @Override
    public Person update(Person person) {
        repository.save(person);
        return person;
    }

}
