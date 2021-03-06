package com.sportproject.gym.DTO;

import com.sportproject.gym.entity.Person;
import com.sportproject.gym.entity.Visit;
import com.sportproject.gym.mapper.CommonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Egor on 01.07.2020.
 */
@SpringBootTest
class PersonDTOTest {

    @Autowired
    private CommonMapper mapper;

    @Test
    public void testToDto() {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Егор");
        person.setLastName("Кохан");
        person.setAge(25);
        List<Visit> visits = Collections.singletonList(new Visit());
        person.setVisits(visits);

        PersonDTO personDto = mapper.personToPersonDTO(person);

        assertEquals(person.getId(), personDto.getId());
        assertEquals(person.getFirstName(), personDto.getFirstName());
        assertEquals(person.getLastName(), personDto.getLastName());
        assertEquals(person.getAge(), personDto.getAge());
        assertNull(personDto.getVisits());
    }

    @Test
    public void testToEntity() {
        PersonDTO personDto = new PersonDTO();
        personDto.setId(1L);
        personDto.setFirstName("Егор");
        personDto.setLastName("Кохан");
        personDto.setAge(25);

        Person person = mapper.personDtoToPerson(personDto);

        assertEquals(personDto.getId(), person.getId());
        assertEquals(personDto.getFirstName(), person.getFirstName());
        assertEquals(personDto.getLastName(), person.getLastName());
        assertEquals(personDto.getAge(), person.getAge());
        assertNull(person.getVisits());
    }

}