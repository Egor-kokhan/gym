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
    private long id;
    private String name;
    private String description;
}
