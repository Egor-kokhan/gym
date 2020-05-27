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
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="person_seq")
    @SequenceGenerator(name="person_seq",
            sequenceName="Person_Sequence", allocationSize=1)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private int age;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Person_Gymnastic",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "gymnastic_id"))
    private Set<Gymnastic> gymnastics;

}