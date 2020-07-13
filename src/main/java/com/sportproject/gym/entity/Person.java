package com.sportproject.gym.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @author Egor on 12.05.2020.
 */
@Data
@EqualsAndHashCode(of = {"id", "firstName", "lastName", "age"})
@ToString(of = {"id", "firstName", "lastName", "age"})
@Entity()
public class Person {

    @Id
    @SequenceGenerator(name = "personSeq", sequenceName = "pesron_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "personSeq")
    private Long id;

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