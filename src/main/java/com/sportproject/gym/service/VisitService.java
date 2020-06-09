package com.sportproject.gym.service;

import com.sportproject.gym.DTO.TrainingDTO;
import com.sportproject.gym.DTO.VisitDTO;

import java.util.List;

/**
 * @author Egor on 08.06.2020.
 */
public interface VisitService {
    List<VisitDTO> getAll();
    VisitDTO get(long id);
    void delete(long id);
    VisitDTO create(VisitDTO visitDTO);
    VisitDTO update(VisitDTO visitDTO);
}
