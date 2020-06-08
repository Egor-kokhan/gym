package com.sportproject.gym.service.impl;

import com.sportproject.gym.DTO.TrainingDTO;
import com.sportproject.gym.entity.Training;
import com.sportproject.gym.mapper.TrainingMapper;
import com.sportproject.gym.repository.TrainingRepository;
import com.sportproject.gym.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Egor on 04.06.2020.
 */
@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository repository;
    private final TrainingMapper mapper;

    @Autowired
    public TrainingServiceImpl(TrainingRepository repository, TrainingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<TrainingDTO> getAll() {
        return mapper.entityToDTO(repository.findAll());
    }

    @Override
    public TrainingDTO get(long id) {
        return mapper.entityToDTO(repository.getOne(id));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public TrainingDTO create(TrainingDTO trainingDTO) {
        Training training = mapper.dTOToEntity(trainingDTO);

        return mapper.entityToDTO(repository.save(training));
    }

    @Override
    public TrainingDTO update(TrainingDTO trainingDTO) {
        return mapper.entityToDTO(repository.save(mapper.dTOToEntity(trainingDTO)));
    }
}
