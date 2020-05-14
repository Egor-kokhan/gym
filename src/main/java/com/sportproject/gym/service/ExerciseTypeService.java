package com.sportproject.gym.service;

import com.sportproject.gym.entity.ExerciseType;

import java.util.List;

/**
 * @author Alex on 14.05.2020.
 */
public interface ExerciseTypeService {
    List<ExerciseType> getAll();
    ExerciseType getByName(String name);
    ExerciseType getById(Long id);
}
