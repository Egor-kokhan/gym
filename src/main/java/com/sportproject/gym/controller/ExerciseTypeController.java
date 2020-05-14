package com.sportproject.gym.controller;

import com.sportproject.gym.entity.ExerciseType;
import com.sportproject.gym.entity.Person;
import com.sportproject.gym.service.ExerciseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alex on 14.05.2020.
 * localhost/exerciseType/Жим от груди
 */
@RestController
@RequestMapping(value = "/exerciseType", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExerciseTypeController {
    private ExerciseTypeService service;

    @Autowired
    public ExerciseTypeController(ExerciseTypeService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<ExerciseType>> getExerciseTypes() {
        List<ExerciseType> exerciseTypes = service.getAll();
        return ResponseEntity.ok(exerciseTypes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExerciseType> getExerciseTypeById (@PathVariable Long id) {
        ExerciseType exerciseType = service.getById(id);
        return ResponseEntity.ok(exerciseType);
    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity<ExerciseType> getExerciseTypeByName (@RequestParam String name) {
        ExerciseType exerciseType = service.getByName(name);
        return ResponseEntity.ok(exerciseType);
    }
}
