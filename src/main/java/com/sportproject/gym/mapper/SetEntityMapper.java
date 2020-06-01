package com.sportproject.gym.mapper;

import com.sportproject.gym.DTO.SetEntityDTO;
import com.sportproject.gym.entity.SetEntity;
import org.mapstruct.Mapper;

/**
 * @author Egor on 27.05.2020.
 */
@Mapper(componentModel = "spring")
public interface SetEntityMapper {
//    SetEntity dTOToEntity(SetEntityDTO setEntityDTO);
    SetEntityDTO entityToDTO(SetEntity setEntity);
}
