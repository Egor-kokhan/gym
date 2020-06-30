package com.sportproject.gym.repository;

import com.sportproject.gym.entity.Gymnastic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alex on 14.05.2020.
 */
public interface GymnasticRepository extends JpaRepository<Gymnastic, Long> {

}
