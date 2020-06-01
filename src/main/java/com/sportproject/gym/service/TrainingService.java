package com.sportproject.gym.service;

import com.sportproject.gym.DTO.TrainingDTO;
import com.sportproject.gym.entity.Training;

import java.util.List;

/**
 * @author Egor on 27.05.2020.
 */
public interface TrainingService {
    List<TrainingDTO> getAll();
    TrainingDTO get(long id);
    TrainingDTO create(Training training);
    TrainingDTO update(Training training);
    void delete(long id);
}
