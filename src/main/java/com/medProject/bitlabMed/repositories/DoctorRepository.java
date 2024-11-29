package com.medProject.bitlabMed.repositories;

import com.medProject.bitlabMed.entities.Doctor.Doctor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    @Query("SELECT d FROM Doctor d WHERE LOWER(d.doctorSpeciality) LIKE LOWER(CONCAT('%', :speciality, '%'))")
    List<Doctor> findByDoctorSpecialityIgnoreCase(String speciality);
}
