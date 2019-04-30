package com.eureka.github.repository;

import com.eureka.github.models.entity.CodeReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeReviewCommentRepository extends JpaRepository<CodeReviewComment, Integer> {
}
