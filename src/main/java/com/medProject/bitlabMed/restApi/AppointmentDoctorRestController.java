package com.medProject.bitlabMed.restApi;


import com.medProject.bitlabMed.dtos.DoctorDto.AppointmentDoctorDto;
import com.medProject.bitlabMed.entities.Doctor.AppointmentDoctor;
import com.medProject.bitlabMed.mappers.AppointmentDoctorMapper;
import com.medProject.bitlabMed.services.AppointmentDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment-doctor")
public class AppointmentDoctorRestController {

        private final AppointmentDoctorService appointmentDoctorService;
        private final AppointmentDoctorMapper appointmentDoctorMapper;

        @GetMapping("/week-schedule")
        @ResponseBody
        public Map<LocalDate, List<LocalTime>> getWeekSchedule(
                @RequestParam Long doctorId,
                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {

                return appointmentDoctorService.getWeekSchedule(doctorId, startDate);
        }

        @PostMapping(value = "/addAppointmentDoctor")
        public Long addAppointmentDoctor(@ModelAttribute AppointmentDoctorDto appointmentDoctorDto) {

                AppointmentDoctor savedAppointmentDoctor = appointmentDoctorMapper.toEntity(appointmentDoctorService.addAppointmentDoctor(appointmentDoctorDto));
                Long savedId = savedAppointmentDoctor.getId();
                return savedId;
        }

        @GetMapping(value = "/getAllAppointments")
        public List<AppointmentDoctorDto> getAllAppointments(){
                return appointmentDoctorService.getAllAppointmentDoctorsList();
        }

        @GetMapping(value = "/getAppointmentById/{id}")
        public AppointmentDoctorDto getAppointmentById(@PathVariable Long id){
                return appointmentDoctorService.getAppointmentDoctorById(id);
        }

        @DeleteMapping(value = "/deleteAppointmentById/{id}")
        public void deleteAppointmentById(@PathVariable Long id){
                appointmentDoctorService.deleteAppointmentDoctorById(id);
        }
}

