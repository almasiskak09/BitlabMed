package com.medProject.bitlabMed.repositories;

import com.medProject.bitlabMed.entities.Doctor.AppointmentDoctor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface AppointmentDoctorRepository extends JpaRepository<AppointmentDoctor,Long> {
    List<AppointmentDoctor> findByDoctorIdAndAppointmentDateBetween(Long doctorId, LocalDate startDate, LocalDate endDate);
    List<AppointmentDoctor> findByUserId(Long userId);
}
