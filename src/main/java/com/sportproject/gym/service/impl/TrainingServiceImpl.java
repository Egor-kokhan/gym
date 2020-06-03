package com.sportproject.gym.service.impl;

import com.sportproject.gym.DTO.TrainingDTO;
import com.sportproject.gym.entity.Training;
import com.sportproject.gym.repository.TrainingRepository;
import com.sportproject.gym.service.TrainingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Egor on 27.05.2020.
 */
@Service
public class TrainingServiceImpl implements TrainingService {

    private TrainingRepository repository;

    @Override
    public List<TrainingDTO> getAll() {
        return null;
    }

    @Override
    public TrainingDTO get(long id) {
        return null;
    }

    @Override
    public TrainingDTO create(Training training) {
        return null;
    }

    @Override
    public TrainingDTO update(Training training) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
