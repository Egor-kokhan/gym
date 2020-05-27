package com.sportproject.gym.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sportproject.gym.entity.Gymnastic;
import com.sportproject.gym.entity.Person;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Egor on 18.05.2020.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GymnasticDTO {
    private String name;

    private String description;

    private Set<PersonDTO> persons;

    public static List<GymnasticDTO> mappingGymnasticToDTO(List<Gymnastic> gymnastics) {
        List<GymnasticDTO> resultDto = new ArrayList<>();
        for (Gymnastic gymnastic : gymnastics) {
            GymnasticDTO gymnasticDTO = new GymnasticDTO();
            gymnasticDTO.setDescription(gymnastic.getDescription());
            gymnasticDTO.setName(gymnastic.getName());

            Set<PersonDTO> personDTOS = new HashSet<>();

            for (Person person :gymnastic.getPersons()) {
                PersonDTO personDTO = new PersonDTO();
                personDTO.setAge(person.getAge());
                personDTO.setFirstName(person.getFirstName());
                personDTO.setLastName(person.getLastName());
                personDTOS.add(personDTO);
            }

            gymnasticDTO.setPersons(personDTOS);
            resultDto.add(gymnasticDTO);
        }
        return resultDto;

    }
}
