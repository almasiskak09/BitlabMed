package com.medProject.bitlabMed.controllers;

import com.medProject.bitlabMed.dtos.DoctorDto.AppointmentDoctorDto;
import com.medProject.bitlabMed.dtos.DoctorDto.DoctorDTO;
import com.medProject.bitlabMed.entities.Doctor.AppointmentDoctor;
import com.medProject.bitlabMed.mappers.AppointmentDoctorMapper;
import com.medProject.bitlabMed.services.AppointmentDoctorService;
import com.medProject.bitlabMed.services.DoctorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class DoctorController {


    private final DoctorService doctorService;
    private final AppointmentDoctorService appointmentDoctorService;
    private final AppointmentDoctorMapper appointmentDoctorMapper;

    @GetMapping(value = "/doctors")
    public String doctorsPage(Model model) {
        List<DoctorDTO> doctorList = doctorService.getAllDoctors();
        model.addAttribute("doctorsList", doctorList);
        return "doctors";
    }

    @GetMapping("/week-schedule")
    @ResponseBody
    public Map<LocalDate, List<LocalTime>> getWeekSchedule(
            @RequestParam Long doctorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {

        return appointmentDoctorService.getWeekSchedule(doctorId, startDate);
    }

    @PostMapping(value = "/addAppointmentDoctor")
    @ResponseBody
    public Long addAppointmentDoctor(@ModelAttribute AppointmentDoctorDto appointmentDoctorDto) {

        AppointmentDoctor savedAppointmentDoctor = appointmentDoctorMapper.toEntity(appointmentDoctorService.addAppointmentDoctor(appointmentDoctorDto));
        Long savedId = savedAppointmentDoctor.getId();

        return savedId;

    }

    @GetMapping(value = {"/app-doctor/{id}", "/app-doctor/delete-success"})
    public String appointmentDoctorPage(Model model, @PathVariable(required = false) Long id, HttpServletRequest request) {
        if (id != null) {
            AppointmentDoctorDto appointment = appointmentDoctorService.getAppointmentDoctorById(id);
            DoctorDTO doctor = doctorService.getDoctorById(appointment.getDoctorId());

            model.addAttribute("appointment", appointment);
            model.addAttribute("doctor", doctor);
            model.addAttribute("deleteSuccess", false);
        } else {
            model.addAttribute("deleteSuccess", true);
        }
        return "app-doctor";
    }


    @PostMapping(value = "/deleteAppointment")
    public String deleteAppointment(@RequestParam Long appointmentId) {
        appointmentDoctorService.deleteAppointmentDoctorById(appointmentId);
        return "redirect:/app-doctor/delete-success";
    }
}





