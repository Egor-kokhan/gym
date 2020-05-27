package com.sportproject.gym.service.impl;

import com.sportproject.gym.DTO.SetEntityDTO;
import com.sportproject.gym.entity.SetEntity;
import com.sportproject.gym.repository.SetEntityRepository;
import com.sportproject.gym.service.SetEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex on 27.05.2020.
 */
@Service
public class SetEntityServiceImpl implements SetEntityService {

    private SetEntityRepository repository;

    @Autowired
    public SetEntityServiceImpl (SetEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SetEntityDTO> getAll() {
        List<SetEntityDTO> sets = SetEntityDTO. (repository.findAll());
        return sets;
    }

    @Override
    public SetEntityDTO get(long id) {
        SetEntityDTO set = SetEntityDTO. (repository.findById(id));
        return set;
    }

    @Override
    public SetEntityDTO create(SetEntity setEntity) {
        SetEntityDTO set = SetEntityDTO. (repository.save(setEntity));
        return set;
    }

    @Override
    public SetEntityDTO update(SetEntity setEntity) {
        SetEntityDTO set = SetEntityDTO. (repository.save(setEntity));
        return set;
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
