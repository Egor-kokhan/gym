package com.sportproject.gym.service.impl;

import com.sportproject.gym.DTO.SetEntityDTO;

import com.sportproject.gym.mapper.CommonMapper;
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

    private final SetEntityRepository repository;
    private final CommonMapper mapper;

    @Autowired
    public SetEntityServiceImpl(SetEntityRepository repository, CommonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<SetEntityDTO> getAll() {
        return mapper.setEntityToSetEntityDto(repository.findAll());
    }

    @Override
    public SetEntityDTO get(long id) {

        if (repository.existsById(id)){
            return mapper.setEntityToSetEntityDto(repository.getOne(id));
        } else {
            System.out.println("Нет с таким id");
            return null;
        }
    }

    @Override
    public SetEntityDTO create(SetEntityDTO setEntityDTO) {
        return mapper.setEntityToSetEntityDto(repository.save(mapper.setEntityDtoToSetEntity(setEntityDTO)));
    }

    @Override
    public SetEntityDTO update(SetEntityDTO setEntityDTO) {
        return mapper.setEntityToSetEntityDto(repository.save(mapper.setEntityDtoToSetEntity(setEntityDTO)));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
