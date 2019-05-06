package com.service.scorer.repository;

import com.service.scorer.models.entity.RepoRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepoRankRepository extends JpaRepository<RepoRank, Integer> {

    List<RepoRank> findTop20ByRepoNameOrderByScoreDesc(String repoName);

    @Query("SELECT DISTINCT r.repoName FROM RepoRank r")
    List<String> findDistinctRepos();

}
