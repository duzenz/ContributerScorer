package com.eureka.github.repository;

import com.eureka.github.models.entity.CodeReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodeReviewRepository extends JpaRepository<CodeReview, Integer> {

    List<CodeReview> findByRepoName(String repoName);
}
