package com.sportproject.gym.controller;

import com.sportproject.gym.DTO.TrainingDTO;
import com.sportproject.gym.entity.Training;
import com.sportproject.gym.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Egor on 27.05.2020.
 */
@RestController
@RequestMapping(value = "/training", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainingController {
    private TrainingService service;

    @Autowired
    public TrainingController(TrainingService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<TrainingDTO>> getAll() {
        List<TrainingDTO> trainings = service.getAll();
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingDTO> get(@PathVariable long id) {
        TrainingDTO trainingDTO = service.get(id);
        return ResponseEntity.ok(trainingDTO);
    }

    @PostMapping()
    public ResponseEntity<TrainingDTO> create(@RequestBody Training training) {
        TrainingDTO newTrainingDTO = service.create(training);
        return ResponseEntity.ok(newTrainingDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

}
