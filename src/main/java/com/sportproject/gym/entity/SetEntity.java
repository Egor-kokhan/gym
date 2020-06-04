package com.sportproject.gym.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Alex on 27.05.2020.
 */
@Data
@Entity()
public class SetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (nullable = false)
    private int repeats;

    @Column (nullable = false)
    private double weight;

//    @Column (name = "VISIT_ID", nullable = false)
//    private long visitId;
//
//    @Column (name = "GYMNASTIC_ID", nullable = false)
//    private long gymnasticId;


}
