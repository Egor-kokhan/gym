package com.sportproject.gym.service.impl;

import com.sportproject.gym.DTO.VisitDTO;
import com.sportproject.gym.mapper.VisitMapper;
import com.sportproject.gym.repository.VisitRepository;
import com.sportproject.gym.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Egor on 08.06.2020.
 */
@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository repository;
    private final VisitMapper mapper;

    @Autowired
    public VisitServiceImpl(VisitRepository repository, VisitMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override

    public List<VisitDTO> getAll() {
        return mapper.entityToDTO(repository.findAll());
    }

    @Override
    public VisitDTO get(long id) {
        return mapper.entityToDTO(repository.getOne(id));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public VisitDTO create(VisitDTO visitDTO) {
        return mapper.entityToDTO(repository.save(mapper.dTOToEntity(visitDTO)));
    }

    @Override
    public VisitDTO update(VisitDTO visitDTO) {
        return mapper.entityToDTO(repository.save(mapper.dTOToEntity(visitDTO)));
    }
}
