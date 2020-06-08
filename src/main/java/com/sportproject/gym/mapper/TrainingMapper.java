package com.sportproject.gym.mapper;

import com.sportproject.gym.DTO.TrainingDTO;
import com.sportproject.gym.entity.Training;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Egor on 04.06.2020.
 */
@Mapper
public abstract class TrainingMapper {

    public abstract TrainingDTO entityToDTO(Training source);

    public abstract Training dTOToEntity(TrainingDTO source);

    public abstract List<TrainingDTO> entityToDTO(List<Training> source);

}
