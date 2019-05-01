package com.eureka.github.repository;

import com.eureka.github.models.entity.CodeReviewComment;
import com.eureka.github.models.entity.UserStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodeReviewCommentRepository extends JpaRepository<CodeReviewComment, Integer> {

    List<CodeReviewComment> findByRepoName(String repoName);
}
