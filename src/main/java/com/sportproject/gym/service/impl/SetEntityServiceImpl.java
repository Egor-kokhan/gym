package com.sportproject.gym.service.impl;

import com.sportproject.gym.DTO.SetEntityDTO;
import com.sportproject.gym.entity.SetEntity;
import com.sportproject.gym.mapper.SetEntityMapper;
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
    private SetEntityMapper mapper;

    @Autowired
    public SetEntityServiceImpl(SetEntityRepository repository, SetEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<SetEntityDTO> getAll() {
        return mapper.entityToDTO(repository.findAll());
    }

    @Override
    public SetEntityDTO get(long id) {
        if (repository.existsById(id)){
            return mapper.entityToDTO(repository.getOne(id));
        } else {
            System.out.println("Нет с таким id");
            return null;
        }
    }

    @Override
    public SetEntityDTO create(SetEntityDTO setEntityDTO) {
        return mapper.entityToDTO(repository.save(mapper.dTOToEntity(setEntityDTO)));
    }

    @Override
    public SetEntityDTO update(SetEntityDTO setEntityDTO) {
        return mapper.entityToDTO(repository.save(mapper.dTOToEntity(setEntityDTO)));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
