package com.sportproject.gym.mapper;

import com.sportproject.gym.DTO.SetEntityDTO;
import com.sportproject.gym.entity.SetEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Alex on 04.06.2020.
 */
@Mapper
public abstract class SetEntityMapper {
    public abstract SetEntityDTO entityToDTO(SetEntity source);
    public abstract List<SetEntityDTO> entityToDTO(List<SetEntity> source);
    public abstract SetEntity dTOToEntity(SetEntityDTO destination);
}
