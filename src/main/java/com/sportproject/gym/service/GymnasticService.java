package com.sportproject.gym.service;

import com.sportproject.gym.DTO.GymnasticDTO;
import com.sportproject.gym.DTO.SetEntityDTO;
import com.sportproject.gym.entity.Gymnastic;

import java.util.List;

/**
 * @author Alex on 14.05.2020.
 */
public interface GymnasticService {
    List<GymnasticDTO> getAll();
    GymnasticDTO get(long id);
    GymnasticDTO create(GymnasticDTO gymnastic);
    GymnasticDTO update(GymnasticDTO gymnastic);
    void delete(long id);
}
