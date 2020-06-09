package com.sportproject.gym.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Egor on 12.05.2020.
 */
@Data
@Entity()
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private int age;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Visit> visits;

}