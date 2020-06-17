package com.sportproject.gym.service.impl;

import com.sportproject.gym.DTO.PersonDTO;
import com.sportproject.gym.entity.Person;
import com.sportproject.gym.entity.Visit;
import com.sportproject.gym.mapper.PersonMapper;
import com.sportproject.gym.repository.PersonRepository;
import com.sportproject.gym.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author Egor on 12.05.2020.
 */
@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository repository;
    private PersonMapper mapper;


    @Autowired
    public PersonServiceImpl(PersonRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PersonDTO> getAll() {
        List<Person> people = repository.findAll();
//        Set<Visit> visits = people.get(0).getVisits();
        List<PersonDTO> peoples = mapper.entityToDTO(people);
        return peoples;
    }

    @Override
    public PersonDTO get(long id) {
        if (repository.existsById(id)){
            return mapper.entityToDTO(repository.getOne(id));
        } else {
            System.out.println("Нет с таким id");
            return null;
        }
    }

    @Override
    public PersonDTO create(PersonDTO personDTO) {
        return mapper.entityToDTO(repository.save(mapper.dTOToEntity(personDTO)));
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        return mapper.entityToDTO(repository.save(mapper.dTOToEntity(personDTO)));
    }

    @Override
    public void delete(long id) {
        if (!repository.existsById(id)) {
            System.out.println("Запись не найдена");
        } else {
            repository.deleteById(id);
        }
    }
}
