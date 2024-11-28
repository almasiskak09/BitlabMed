package com.medProject.bitlabMed.services;

import com.medProject.bitlabMed.dtos.DoctorDto.AppointmentDoctorDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface AppointmentDoctorService {

    Map<LocalDate, List<LocalTime>> getWeekSchedule(Long doctorId, LocalDate startDate);
    List<AppointmentDoctorDto> getAllAppointmentDoctorsList();
    AppointmentDoctorDto addAppointmentDoctor(AppointmentDoctorDto appointmentDoctorDto);
    AppointmentDoctorDto getAppointmentDoctorById(Long id);
    AppointmentDoctorDto updateAppointmentDoctor(AppointmentDoctorDto appointmentDoctorDto);
    void deleteAppointmentDoctorById(Long id);
    List<AppointmentDoctorDto> getAllAppointmentDoctorListByUserId(Long userId);

}