package com.sportproject.gym.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

/**
 * @author Egor on 12.05.2020.
 *
 *  CREATE TABLE IF NOT EXISTS Person
 * (
 *     id           INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
 *     first_name   VARCHAR(50) NOT NULL COMMENT 'Имя',
 *     last_name    VARCHAR(50) COMMENT 'Фамилия',
 *     age          INTEGER     NOT NULL COMMENT 'Возраст',
 *     created_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Дата регистрации'
 * );
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