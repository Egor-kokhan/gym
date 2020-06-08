package com.sportproject.gym.service;

import com.sportproject.gym.DTO.TrainingDTO;

import java.util.List;

/**
 * @author Egor on 04.06.2020.
 */
public interface TrainingService {
    List<TrainingDTO> getAll();
    TrainingDTO get(long id);
    void delete(long id);
    TrainingDTO create(TrainingDTO trainingDTO);
    TrainingDTO update(TrainingDTO trainingDTO);
}