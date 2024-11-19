package com.medProject.bitlabMed.repositories;

import com.medProject.bitlabMed.entities.Doctor.Doctor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
