package com.sportproject.gym.mapper;

import com.sportproject.gym.DTO.GymnasticDTO;
import com.sportproject.gym.entity.Gymnastic;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Alex on 08.06.2020.
 */
@Mapper
public abstract class GymnasticMapper {
    public abstract GymnasticDTO entityToDTO(Gymnastic source);
    public abstract List<GymnasticDTO> entityToDTO(List<Gymnastic> source);
    public abstract Gymnastic dTOToEntity(GymnasticDTO destination);
}
