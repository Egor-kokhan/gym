package com.sportproject.gym.controller;

import com.sportproject.gym.DTO.PersonDTO;
import com.sportproject.gym.DTO.TrainingDTO;
import com.sportproject.gym.DTO.VisitDTO;
import com.sportproject.gym.entity.Visit;
import com.sportproject.gym.repository.VisitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Egor on 01.07.2020.
 */
@SpringBootTest
@TestPropertySource("/application.properties")
@Sql(value = {"/create-person-before.sql"})
class VisitControllerTest {
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Autowired
    private VisitController controller;

    @Autowired
    private VisitRepository repository;

    @Test
    void getAll() throws Exception {
        VisitDTO visitDto1 = new VisitDTO();
        visitDto1.setId(1L);
        Date date1 = format.parse("2020-08-23 18:25:43.511Z");
        visitDto1.setCreationDateTime(date1);

        VisitDTO visitDto2 = new VisitDTO();
        visitDto2.setId(2L);
        Date date2 = format.parse("2020-10-23 18:25:43.511Z");
        visitDto2.setCreationDateTime(date2);

        ResponseEntity<List<VisitDTO>> responseEntity = controller.getAll();
        List<VisitDTO> visits = responseEntity.getBody();

        assertNotNull(visits);

        assertEquals(1L, visits.get(0).getId());
        assertEquals(date1, visits.get(0).getCreationDateTime());
        assertEquals(1L, visits.get(0).getPerson().getId());

        assertEquals(2L, visits.get(1).getId());
        assertEquals(date2, visits.get(1).getCreationDateTime());
        assertEquals(2L, visits.get(1).getTraining().getId());
    }


    @Test
    void create() throws Exception {
        VisitDTO visitForSave = new VisitDTO();
        Date date1 = format.parse("2020-08-23 18:25:43.511Z");
        visitForSave.setCreationDateTime(date1);

        PersonDTO personDto = new PersonDTO();
        personDto.setId(2L);
        visitForSave.setPerson(personDto);

        TrainingDTO trainingDto = new TrainingDTO();
        trainingDto.setId(2);
        visitForSave.setTraining(trainingDto);


        ResponseEntity<VisitDTO> responseEntity = controller.create(visitForSave);
        VisitDTO savedVisit = responseEntity.getBody();

        assertNotNull(savedVisit);
        assertNotNull(savedVisit.getId());
        assertEquals(visitForSave.getCreationDateTime(), savedVisit.getCreationDateTime());
        assertEquals(visitForSave.getPerson().getId(), savedVisit.getPerson().getId());
        assertEquals(visitForSave.getTraining().getId(), savedVisit.getTraining().getId());


        Optional<Visit> foundVisit = repository.findById(savedVisit.getId());

        assertTrue(foundVisit.isPresent());
        Visit foundedVisit = foundVisit.get();
        assertEquals(visitForSave.getCreationDateTime(), foundedVisit.getCreationDateTime());
        assertEquals(visitForSave.getPerson().getId(), foundedVisit.getPerson().getId());
        assertEquals(visitForSave.getTraining().getId(), foundedVisit.getTraining().getId());
    }

    @Test
    void update() throws Exception {
        VisitDTO visitForUpdate = new VisitDTO();
        visitForUpdate.setId(1L);
        Date date1 = format.parse("2020-08-23 18:25:43.511Z");
        visitForUpdate.setCreationDateTime(date1);

        PersonDTO personDto = new PersonDTO();
        personDto.setId(2L);
        visitForUpdate.setPerson(personDto);

        TrainingDTO trainingDto = new TrainingDTO();
        trainingDto.setId(2);
        visitForUpdate.setTraining(trainingDto);


        ResponseEntity<VisitDTO> responseEntity = controller.update(visitForUpdate);
        VisitDTO updatedVisit = responseEntity.getBody();

        assertNotNull(updatedVisit);
        assertEquals(visitForUpdate.getId(), updatedVisit.getId());
        assertEquals(visitForUpdate.getCreationDateTime(), updatedVisit.getCreationDateTime());
        assertEquals(visitForUpdate.getPerson().getId(), updatedVisit.getPerson().getId());
        assertEquals(visitForUpdate.getTraining().getId(), updatedVisit.getTraining().getId());


        Optional<Visit> foundVisit = repository.findById(updatedVisit.getId());

        assertTrue(foundVisit.isPresent());
        Visit foundedVisit = foundVisit.get();
        assertEquals(visitForUpdate.getCreationDateTime(), foundedVisit.getCreationDateTime());
        assertEquals(visitForUpdate.getPerson().getId(), foundedVisit.getPerson().getId());
        assertEquals(visitForUpdate.getTraining().getId(), foundedVisit.getTraining().getId());
    }

    @Test
    void delete() {
        long deletedId = 1;
        int sizeBeforeDeleting = repository.findAll().size();
        ResponseEntity<?> delete = controller.delete(deletedId);
        int sizeAfterDeleting = repository.findAll().size();

        assertFalse(repository.existsById(deletedId));
        assertTrue(delete.getStatusCode().is2xxSuccessful());
        assertTrue(sizeBeforeDeleting > sizeAfterDeleting);
    }

}