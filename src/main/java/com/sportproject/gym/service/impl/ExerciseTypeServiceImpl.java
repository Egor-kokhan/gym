package com.sportproject.gym.service.impl;

import com.sportproject.gym.entity.ExerciseType;
import com.sportproject.gym.repository.ExerciseTypeRepository;
import com.sportproject.gym.service.ExerciseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex on 14.05.2020.
 */
@Service
public class ExerciseTypeServiceImpl implements ExerciseTypeService {

    private ExerciseTypeRepository repository;

    @Autowired
    public ExerciseTypeServiceImpl(ExerciseTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ExerciseType> getAll() {
        return repository.findAll();
    }

    @Override
    public ExerciseType getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public ExerciseType getById(Long id) {
        return repository.getOne(id);
    }

}
