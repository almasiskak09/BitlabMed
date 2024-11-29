package com.medProject.bitlabMed.repositories;

import com.medProject.bitlabMed.entities.Analyzes.Analyzes;
import com.medProject.bitlabMed.entities.Analyzes.AnalyzesCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface AnalyzesCategoryRepository extends JpaRepository<AnalyzesCategory,Long> {

    @Query("SELECT DISTINCT c FROM AnalyzesCategory c JOIN c.analyzesList a WHERE LOWER(a.analyzesName) LIKE LOWER(CONCAT('%', :analyzeName, '%'))")
    List<AnalyzesCategory> findAnalyzesCategoryByAnalyzeName(String analyzeName);
}

