package com.sportproject.gym.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sportproject.gym.entity.Gymnastic;
import com.sportproject.gym.entity.Person;
import lombok.*;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Egor on 18.05.2020.
 */
@Data
@ToString(of = {"id", "firstName", "lastName", "age"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO {

    private long id;

    private String firstName;

    private String lastName;

    private int age;

    private List<VisitDTO> visits;
}
