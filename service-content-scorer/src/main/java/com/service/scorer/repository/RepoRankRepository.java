package com.service.scorer.repository;

import com.service.scorer.models.entity.RepoRank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoRankRepository extends JpaRepository<RepoRank, Integer> {
}
