package com.eureka.github.repository;

import com.eureka.github.models.entity.UserStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatsRepository extends JpaRepository<UserStats, Integer> {
}
