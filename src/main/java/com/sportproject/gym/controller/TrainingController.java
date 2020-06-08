package com.sportproject.gym.controller;

import com.sportproject.gym.DTO.TrainingDTO;
import com.sportproject.gym.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Egor on 04.06.2020.
 */
@RestController
@RequestMapping(value = "/training", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainingController {

    private TrainingService service;

    @Autowired
    public TrainingController(TrainingService service) {
        this.service = service;
    }

    /**
     * List<TrainingDTO> getAll();
     * TrainingDTO get(long id);
     * void delete(long id);
     * TrainingDTO create(TrainingDTO trainingDTO);
     * TrainingDTO update(TrainingDTO trainingDTO);
     */
    @GetMapping()
    public ResponseEntity<List<TrainingDTO>> getAll() {
        List<TrainingDTO> trainings = service.getAll();
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingDTO> get(@PathVariable long id){
        TrainingDTO training = service.get(id);
        return ResponseEntity.ok(training);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<TrainingDTO> create(@RequestBody TrainingDTO trainingDTO) {
        TrainingDTO training = service.create(trainingDTO);
        return ResponseEntity.ok(training);
    }

    @PutMapping
    public ResponseEntity<TrainingDTO> update(@RequestBody TrainingDTO trainingDTO) {
        TrainingDTO training = service.update(trainingDTO);
        return ResponseEntity.ok(training);
    }

}
