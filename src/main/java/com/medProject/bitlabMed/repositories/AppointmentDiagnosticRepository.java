package com.medProject.bitlabMed.repositories;


import com.medProject.bitlabMed.entities.Diagnostic.AppointmentDiagnostic;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface AppointmentDiagnosticRepository extends JpaRepository<AppointmentDiagnostic,Long> {
    List<AppointmentDiagnostic> findAllByUserId(Long userId);
}
