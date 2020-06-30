package com.sportproject.gym.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Egor on 12.05.2020.
 */
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "firstName", "lastName", "age"})
@Entity()
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private List<Visit> visits;

    public void setVisits(List<Visit> visits) {
        if (visits != null){
            visits.forEach(visit -> visit.setPerson(this));
        }
        this.visits = visits;
    }
}