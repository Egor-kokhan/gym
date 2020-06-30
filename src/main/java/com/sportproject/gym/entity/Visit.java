package com.sportproject.gym.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Alex on 04.06.2020.
 */
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "creationDateTime"})
@Entity()
public class Visit {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column (nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="person_id")
    private Person person;

}
