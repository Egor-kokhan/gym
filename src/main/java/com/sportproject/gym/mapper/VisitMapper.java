package com.sportproject.gym.mapper;

import com.sportproject.gym.DTO.VisitDTO;
import com.sportproject.gym.entity.Visit;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Egor on 08.06.2020.
 */
@Mapper
public abstract class VisitMapper {
    public abstract VisitDTO entityToDTO(Visit source);

    public abstract Visit dTOToEntity(VisitDTO source);

    public abstract List<VisitDTO> entityToDTO(List<Visit> source);

}
