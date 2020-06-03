package com.sportproject.gym.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Egor on 27.05.2020.
 */
@Data
@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Gymnastic> gymnastics;
}
