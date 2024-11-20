package com.medProject.bitlabMed.repositories;

import com.medProject.bitlabMed.entities.Diagnostic.DiagnosticCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DiagnosticCategoryRepository extends JpaRepository<DiagnosticCategory,Long> {
}
