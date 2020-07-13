package com.sportproject.gym.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Egor on 27.05.2020.
 */
@Data
@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

}
