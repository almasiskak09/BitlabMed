package com.medProject.bitlabMed.repositories;

import com.medProject.bitlabMed.entities.Analyzes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface AnalyzesRepository extends JpaRepository<Analyzes,Long> {
}
