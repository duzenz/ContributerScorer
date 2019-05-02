package com.service.scorer.repository;

import com.service.scorer.models.entity.RepoRank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoRankRepository extends JpaRepository<RepoRank, Integer> {

    List<RepoRank> findTop20ByRepoNameOrderByScoreDesc(String repoName);

}
