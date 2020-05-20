package com.sportproject.gym.service.impl;

import com.sportproject.gym.DTO.GymnasticDTO;
import com.sportproject.gym.DTO.PersonDTO;
import com.sportproject.gym.entity.Gymnastic;
import com.sportproject.gym.repository.GymnasticRepository;
import com.sportproject.gym.service.GymnasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex on 14.05.2020.
 */
@Service
public class GymnasticServiceImpl implements GymnasticService {

    private GymnasticRepository repository;

    @Autowired
    public GymnasticServiceImpl(GymnasticRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GymnasticDTO> getAll() {
        return GymnasticDTO.mappingGymnasticToDTO(repository.findAll());
    }

    @Override
    public Gymnastic getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Gymnastic getById(Long id) {
        return repository.getOne(id);
    }

}
