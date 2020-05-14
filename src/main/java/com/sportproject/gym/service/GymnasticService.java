package com.sportproject.gym.service;

import com.sportproject.gym.entity.Gymnastic;

import java.util.List;

/**
 * @author Alex on 14.05.2020.
 */
public interface GymnasticService {
    List<Gymnastic> getAll();
    Gymnastic getByName(String name);
    Gymnastic getById(Long id);
}
