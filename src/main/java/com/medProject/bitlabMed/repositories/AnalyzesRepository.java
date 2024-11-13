package com.medProject.bitlabMed.repositories;

import com.medProject.bitlabMed.dtos.AnalyzesDTO;
import com.medProject.bitlabMed.entities.Analyzes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface AnalyzesRepository extends JpaRepository<Analyzes,Long> {
    List<Analyzes> findByAnalyzesCategory_Id(Long categoryId);
}
