package com.sportproject.gym.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Alex on 14.05.2020.
 */
@Entity()
@Data
public class Gymnastic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}
