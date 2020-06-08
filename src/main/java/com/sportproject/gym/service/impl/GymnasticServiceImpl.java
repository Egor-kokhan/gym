package com.sportproject.gym.service.impl;

import com.sportproject.gym.DTO.GymnasticDTO;
import com.sportproject.gym.mapper.GymnasticMapper;
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
    private final GymnasticMapper mapper;

    @Autowired
    public GymnasticServiceImpl(GymnasticRepository repository, GymnasticMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<GymnasticDTO> getAll() {
        return mapper.entityToDTO(repository.findAll());
    }

    @Override
    public GymnasticDTO get(long id) {
        if (repository.existsById(id)){
            return mapper.entityToDTO(repository.getOne(id));
        } else {
            System.out.println("Нет с таким id");
            return null;
        }
    }

    @Override
    public GymnasticDTO create(GymnasticDTO gymnastic) {
        return mapper.entityToDTO(repository.save(mapper.dTOToEntity(gymnastic)));
    }

    @Override
    public GymnasticDTO update(GymnasticDTO gymnastic) {
        return mapper.entityToDTO(repository.save(mapper.dTOToEntity(gymnastic)));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
