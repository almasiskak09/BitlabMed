package com.medProject.bitlabMed.repositories;

import com.medProject.bitlabMed.dtos.AnalyzesDto.ApplicationAnalyzesDTO;
import com.medProject.bitlabMed.entities.Analyzes.ApplicationAnalyzes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ApplicationAnalyzesRepository extends JpaRepository<ApplicationAnalyzes, Long> {
    List<ApplicationAnalyzes> findAllByUserId(Long ids);
}
