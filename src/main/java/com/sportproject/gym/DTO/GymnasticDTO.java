package com.sportproject.gym.DTO;

import com.sportproject.gym.entity.Gymnastic;
import com.sportproject.gym.entity.Person;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Egor on 18.05.2020.
 */
@Data
public class GymnasticDTO {
    private String name;

    private String description;

    private Set<Person> persons;

    public static List<GymnasticDTO> mappingGymnasticToDTO(List<Gymnastic> gymnastics) {
        List<GymnasticDTO> resultDto = new ArrayList<>();
        for (Gymnastic gymnastic : gymnastics) {
            GymnasticDTO gymnasticDTO = new GymnasticDTO();
            gymnasticDTO.setDescription(gymnastic.getDescription());
            gymnasticDTO.setName(gymnastic.getName());
            resultDto.add(gymnasticDTO);
        }
        return resultDto;

    }
}
