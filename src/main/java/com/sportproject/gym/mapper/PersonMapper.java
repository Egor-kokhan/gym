package com.sportproject.gym.mapper;

import com.sportproject.gym.DTO.PersonDTO;
import com.sportproject.gym.entity.Person;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Egor on 01.06.2020.
 */
@Mapper(componentModel = "spring")
@DecoratedWith(PersonMapperDecorator.class)
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class );

    PersonDTO personToPersonDto(Person person);

}

