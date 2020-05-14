package com.sportproject.gym.repository;

import com.sportproject.gym.entity.ExerciseType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Alex on 14.05.2020.
 */
public interface ExerciseTypeRepository extends JpaRepository<ExerciseType, Long> {
    ExerciseType findByName(String name);

}
