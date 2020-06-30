package com.sportproject.gym.service.impl;

import com.sportproject.gym.DTO.PersonDTO;
import com.sportproject.gym.entity.Person;
import com.sportproject.gym.mapper.CommonMapper;
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
    private CommonMapper mapper;


    @Autowired
    public PersonServiceImpl(PersonRepository repository, CommonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PersonDTO> getAll() {
        List<Person> all = repository.findAll();
        List<PersonDTO> personDTOS = mapper.personToPersonDTO(all);
        return personDTOS;
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
    public PersonDTO create(PersonDTO personDTO) {
        return mapper.personToPersonDTO(repository.save(mapper.personDtoToPerson(personDTO)));
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        return mapper.personToPersonDTO(repository.save(mapper.personDtoToPerson(personDTO)));
    }

}
