package com.sportproject.gym.mapper;

import com.sportproject.gym.DTO.PersonDTO;
import com.sportproject.gym.entity.Person;
import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * @author Alex on 03.06.2020.
 */

@Mapper
public abstract class PersonMapper {
    public abstract PersonDTO entityToDTO(Person source);
    @InheritInverseConfiguration
    public abstract List<PersonDTO> entityToDTO(List<Person> source);

    public abstract Person dTOToEntity(PersonDTO destination);

    @AfterMapping
    public void afterEntityToDTO(List<Person> source, @MappingTarget List<PersonDTO> target) {
        for (PersonDTO personDTO : target) {
            if (personDTO.getGymnastics().isEmpty()){
                personDTO.setGymnastics(null);
            }
        }
    }
}
