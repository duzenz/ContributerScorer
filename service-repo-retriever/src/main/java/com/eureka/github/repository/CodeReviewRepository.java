package com.eureka.github.repository;

import com.eureka.github.models.entity.CodeReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeReviewRepository extends JpaRepository<CodeReview, Integer> {
}
