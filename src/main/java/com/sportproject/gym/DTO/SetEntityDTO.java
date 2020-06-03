package com.sportproject.gym.DTO;

import org.mapstruct.Mapper;

/**
 * @author Alex on 27.05.2020.
 */
@Mapper
public class SetEntityDTO {
    private long id;
    private int repeats;
    private double weight;
    private long visitId;
    private long gymnasticId;
}
