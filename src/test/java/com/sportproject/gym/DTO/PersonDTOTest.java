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

        assertEquals(1, personDto.getId());
        assertEquals("Егор", personDto.getFirstName());
        assertEquals("Кохан", personDto.getLastName());
        assertEquals(25, personDto.getAge());
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

        assertEquals(1, person.getId());
        assertEquals("Егор", person.getFirstName());
        assertEquals("Кохан", person.getLastName());
        assertEquals(25, person.getAge());
        assertNull(person.getVisits());
    }

}