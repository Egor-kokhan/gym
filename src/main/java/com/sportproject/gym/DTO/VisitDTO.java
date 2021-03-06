package com.sportproject.gym.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * @author Alex on 08.06.2020.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VisitDTO {
    private Long id;
    private Date creationDateTime;

    private PersonDTO person;

    private TrainingDTO training;

}
