package com.medProject.bitlabMed.repositories;

import com.medProject.bitlabMed.entities.DiagnosticResult;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DiagnosticResultRepository extends JpaRepository<DiagnosticResult,Long> {
}
