package com.sportproject.gym.DTO;

import com.sportproject.gym.entity.Person;
import com.sportproject.gym.entity.SetEntity;
import com.sportproject.gym.entity.Training;
import com.sportproject.gym.entity.Visit;
import com.sportproject.gym.mapper.CommonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Egor on 14.07.2020.
 */
@SpringBootTest
public class SetEntityDTOTest {

    @Autowired
    private CommonMapper mapper;

    @Test
    public void testToDto() {
        SetEntity set = new SetEntity();
        set.setId(1L);
        set.setRepeats(4);
        set.setWeight(34);

        Visit visit = new Visit();
        visit.setId(1L);
        visit.setCreationDateTime(new Date());
        visit.setPerson(new Person());
        visit.setTraining(new Training());
        
        set.setVisit(visit);

        SetEntityDTO setDto = mapper.setEntityToSetEntityDto(set);


        assertEquals(set.getId(), setDto.getId());
        assertEquals(set.getRepeats(), setDto.getRepeats());
        assertEquals(set.getWeight(), setDto.getWeight());
        assertEquals(set.getVisit().getId(), setDto.getVisit().getId());
//        assertNull(personDto.getVisits());
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
