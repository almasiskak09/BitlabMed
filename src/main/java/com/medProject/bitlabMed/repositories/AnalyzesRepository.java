package com.medProject.bitlabMed.repositories;

import com.medProject.bitlabMed.entities.Analyzes.Analyzes;
import com.medProject.bitlabMed.entities.Doctor.Doctor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface AnalyzesRepository extends JpaRepository<Analyzes,Long> {
    List<Analyzes> findByAnalyzesCategory_Id(Long categoryId);


}
