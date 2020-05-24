package com.sportproject.gym.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sportproject.gym.entity.Gymnastic;
import com.sportproject.gym.entity.Person;
import lombok.*;

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
public class PersonDTO {

    private String firstName;

    private String lastName;

    private int age;

    private String today;

    private Set<GymnasticDTO> gymnastics;

    public static List<PersonDTO> mappingPersonToDTO(List<Person> persons) {
        List<PersonDTO> resultDto = new ArrayList<>();
        for (Person person : persons) {
            PersonDTO personDTO = new PersonDTO();
            personDTO.setAge(person.getAge());
            personDTO.setFirstName(person.getFirstName());
            personDTO.setLastName(person.getLastName());
            personDTO.setToday(LocalDateTime.now().toString());

            Set<GymnasticDTO> gymnasticDTOS = new HashSet<>();

            for (Gymnastic gymnastic : person.getGymnastics()) {
                GymnasticDTO gymnasticDTO = new GymnasticDTO();
                gymnasticDTO.setDescription(gymnastic.getDescription());
                gymnasticDTO.setName(gymnastic.getName());
                gymnasticDTOS.add(gymnasticDTO);
            }
            if (!gymnasticDTOS.isEmpty()) {
                personDTO.setGymnastics(gymnasticDTOS);
            }

            resultDto.add(personDTO);

        }
        return resultDto;
    }

}
