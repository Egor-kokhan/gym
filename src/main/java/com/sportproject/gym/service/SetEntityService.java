package com.sportproject.gym.service;

import com.sportproject.gym.DTO.SetEntityDTO;
import com.sportproject.gym.entity.SetEntity;

import java.util.List;

/**
 * @author Alex on 27.05.2020.
 */
public interface SetEntityService {
    List<SetEntityDTO> getAll();
    SetEntityDTO get(long id);
    SetEntityDTO create(SetEntity setEntity);
    SetEntityDTO update(SetEntity setEntity);
    void delete(long id);
}
