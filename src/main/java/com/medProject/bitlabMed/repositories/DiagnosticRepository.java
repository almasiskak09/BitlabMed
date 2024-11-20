package com.medProject.bitlabMed.repositories;

import com.medProject.bitlabMed.entities.Diagnostic.Diagnostic;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DiagnosticRepository extends JpaRepository<Diagnostic,Long> {
}
