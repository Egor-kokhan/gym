package com.sportproject.gym.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author Alex on 27.05.2020.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetEntityDTO {
    private long id;
    private int repeats;
    private double weight;
//    private long visitId;
//    private long gymnasticId;
}
