package com.sportproject.gym.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Alex on 04.06.2020.
 */
@Data
@Entity()
public class Visit {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column (nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

    @ManyToOne
    private Person personOwner;

}
