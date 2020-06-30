package com.sportproject.gym.service.impl;

import com.sportproject.gym.DTO.VisitDTO;
import com.sportproject.gym.entity.Visit;
import com.sportproject.gym.mapper.CommonMapper;
import com.sportproject.gym.repository.PersonRepository;
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
    private final PersonRepository personRepository;
    private final CommonMapper mapper;

    @Autowired
    public VisitServiceImpl(VisitRepository repository, PersonRepository personRepository, CommonMapper mapper) {
        this.repository = repository;
        this.personRepository = personRepository;
        this.mapper = mapper;
    }

    @Override

    public List<VisitDTO> getAll() {
        List<Visit> all = repository.findAll();
        List<VisitDTO> visitDTOS = mapper.visitToVisitDto(all);
        return visitDTOS;
    }

    @Override
    public VisitDTO get(long id) {
        return mapper.visitToVisitDto(repository.getOne(id));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public VisitDTO create(VisitDTO visitDTO) {
        return mapper.visitToVisitDto(repository.save(mapper.visitDtoToVisit(visitDTO)));
    }

    @Override
    public VisitDTO update(VisitDTO visitDTO) {
        return mapper.visitToVisitDto(repository.save(mapper.visitDtoToVisit(visitDTO)));
    }
}
