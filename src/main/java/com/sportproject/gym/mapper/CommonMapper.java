package com.sportproject.gym.mapper;

import com.sportproject.gym.DTO.*;
import com.sportproject.gym.entity.*;
import org.mapstruct.*;

import java.util.List;

/**
 * @author Egor on 30.06.2020.
 */
@Mapper
public abstract class CommonMapper {

    //Gymnastic Mapper

    public abstract GymnasticDTO gymnasticToGymnasticDto(Gymnastic source);

    public abstract Gymnastic gymnasticDtoToGymnastic(GymnasticDTO source);

    public abstract List<GymnasticDTO> gymnasticToGymnasticDto(List<Gymnastic> source);


    //Person Mapper

    @Mapping(target = "visits", ignore = true)
    public abstract PersonDTO personToPersonDTO(Person source);

    public abstract Person personDtoToPerson(PersonDTO source);

    @InheritInverseConfiguration
    public abstract List<PersonDTO> personToPersonDTO(List<Person> source);


    //Visit Mapper

    public abstract VisitDTO visitToVisitDto(Visit source);

    public abstract Visit visitDtoToVisit(VisitDTO source);

    public abstract List<VisitDTO> visitToVisitDto(List<Visit> source);


    //SetEntity Mapper

    public abstract SetEntityDTO setEntityToSetEntityDto(SetEntity source);

    public abstract SetEntity setEntityDtoToSetEntity(SetEntityDTO source);

    public abstract List<SetEntityDTO> setEntityToSetEntityDto(List<SetEntity> source);


    //Training Mapper

    public abstract TrainingDTO trainingToTrainingDTO(Training source);

    public abstract Training trainingDtoToTraining(TrainingDTO source);

    public abstract List<TrainingDTO> trainingToTrainingDTO(List<Training> source);

}
