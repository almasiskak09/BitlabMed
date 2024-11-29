package com.medProject.bitlabMed.repositories;

import com.medProject.bitlabMed.entities.Analyzes.AnalyzesCategory;
import com.medProject.bitlabMed.entities.Diagnostic.DiagnosticCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface DiagnosticCategoryRepository extends JpaRepository<DiagnosticCategory,Long> {

    @Query("SELECT DISTINCT c FROM DiagnosticCategory c JOIN c.diagnosticList a WHERE LOWER(a.diagnosticName) LIKE LOWER(CONCAT('%', :diagnosticName, '%'))")
    List<DiagnosticCategory> findADiagnosticCategoryByDiagnosticNameContainingIgnoreCase(String diagnosticName);
}
