package com.sportproject.gym.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author Egor on 04.06.2020.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrainingDTO {

    private long id;

    private String name;

    private String description;

}
