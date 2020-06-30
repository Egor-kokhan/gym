package com.sportproject.gym.repository;

import com.sportproject.gym.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Egor on 08.06.2020.
 */
public interface VisitRepository extends JpaRepository<Visit, Long> {
}
