package com.sportproject.gym.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Egor on 18.05.2020.
 */
@Data
@ToString(of = {"id", "firstName", "lastName", "age"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    private List<VisitDTO> visits;
}
