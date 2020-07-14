package com.sportproject.gym.DTO;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.sportproject.gym.entity.Visit;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Alex on 27.05.2020.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetEntityDTO {

    private Long id;
    private int repeats;
    private double weight;
    private VisitDTO visit;

}
