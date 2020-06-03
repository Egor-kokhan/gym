package com.sportproject.gym.mapper;

import com.sportproject.gym.DTO.PersonDTO;
import com.sportproject.gym.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Egor on 01.06.2020.
 */
public abstract class PersonMapperDecorator implements PersonMapper {

    @Autowired
    @Qualifier("delegate")
    private final PersonMapper delegate;

    public PersonMapperDecorator(PersonMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public PersonDTO personToPersonDto(Person person) {
        PersonDTO dto = delegate.personToPersonDto(person);
        dto.setFirstName("Чупакабра");
        return dto;
    }
}