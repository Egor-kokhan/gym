package com.sportproject.gym.repository;

import com.sportproject.gym.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Egor on 12.05.2020.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
