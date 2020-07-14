package com.sportproject.gym.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Alex on 27.05.2020.
 */
@Data
@EqualsAndHashCode(of = {"id", "repeats", "weight"})
@ToString(of = {"id", "repeats", "weight"})
@Entity()
public class SetEntity {

    @Id
    @SequenceGenerator(name = "SetEntitySeq", sequenceName = "set_entity_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "SetEntitySeq")
    private Long id;

    @Column (nullable = false)
    private int repeats;

    @Column (nullable = false)
    private double weight;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visit_id", nullable = false)
    private Visit visit;

}
