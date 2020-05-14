package com.sportproject.gym.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

/**
 * @author Egor on 12.05.2020.
 */
@Entity()
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private int age;
}