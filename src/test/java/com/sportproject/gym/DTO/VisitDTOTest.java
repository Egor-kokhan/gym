package com.sportproject.gym.DTO;

import com.sportproject.gym.entity.Person;
import com.sportproject.gym.entity.Training;
import com.sportproject.gym.entity.Visit;
import com.sportproject.gym.mapper.CommonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Alex on 13.07.2020.
 */
@SpringBootTest
public class VisitDTOTest {

    @Autowired
    private CommonMapper mapper;

    @Test
    public void testToDto() {
        Visit visit = new Visit();
        visit.setId(1L);
        Date date = new Date();
        visit.setCreationDateTime(date);

        Person person = new Person();
        person.setId(2L);
        person.setAge(25);
        person.setFirstName("Егор");
        person.setLastName("Кохан");
        List<Visit> visits = Collections.singletonList(new Visit());
        person.setVisits(visits);
        visit.setPerson(person);

        Training training = new Training();
        training.setId(3L);
        training.setName("День ног");
        training.setDescription("День ног, отвечаю");
        visit.setTraining(training);

        VisitDTO visitDto = mapper.visitToVisitDto(visit);

        assertEquals(1, visitDto.getId());
        assertEquals(date, visitDto.getCreationDateTime());
        assertEquals(2L, visitDto.getPerson().getId());
        assertEquals(3L, visitDto.getTraining().getId());
    }

    @Test
    public void testToEntity() {
        VisitDTO visitDto = new VisitDTO();
        visitDto.setId(1L);
        Date date = new Date();
        visitDto.setCreationDateTime(date);

        PersonDTO personDto = new PersonDTO();
        personDto.setId(2L);
        personDto.setAge(25);
        personDto.setFirstName("Егор");
        personDto.setLastName("Кохан");
        List<VisitDTO> visits = Collections.singletonList(new VisitDTO());
        personDto.setVisits(visits);
        visitDto.setPerson(personDto);

        TrainingDTO trainingDto = new TrainingDTO();
        trainingDto.setId(3L);
        trainingDto.setName("День ног");
        trainingDto.setDescription("День ног, отвечаю");
        visitDto.setTraining(trainingDto);

        Visit visit = mapper.visitDtoToVisit(visitDto);

        assertEquals(1, visit.getId());
        assertEquals(date, visit.getCreationDateTime());
        assertEquals(2L, visit.getPerson().getId());
        assertEquals(3L, visit.getTraining().getId());
    }

}
