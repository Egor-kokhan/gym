package com.sportproject.gym.repository;

import com.sportproject.gym.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Egor on 04.06.2020.
 */
public interface TrainingRepository extends JpaRepository<Training, Long> {
}
