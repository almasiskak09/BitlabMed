package com.medProject.bitlabMed.restApi;


import com.medProject.bitlabMed.services.AppointmentDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointments")
public class AppointmentDoctorRestController {

        @Autowired
        private AppointmentDoctorService appointmentDoctorService;

        @GetMapping("/week-schedule")
        public Map<LocalDate, List<LocalTime>> getWeekSchedule(
                @RequestParam Long doctorId,
                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
            return appointmentDoctorService.getWeekSchedule(doctorId, startDate);
        }

//        @PostMapping("/book")
//        public ResponseEntity<String> bookAppointment(@RequestBody AppointmentDto appointmentDto) {
//            // Проверка занятости
//            List<LocalTime> availableSlots = appointmentService.getWeekSchedule(
//                    appointmentDto.getDoctorId(),
//                    appointmentDto.getDate()
//            ).get(appointmentDto.getDate());
//
//            if (!availableSlots.contains(appointmentDto.getStartTime())) {
//                return ResponseEntity.status(HttpStatus.CONFLICT).body("Время уже занято");
//            }
//
//            // Сохранение записи
//            Appointment appointment = new Appointment();
//            appointment.setDoctorId(appointmentDto.getDoctorId());
//            appointment.setDate(appointmentDto.getDate());
//            appointment.setStartTime(appointmentDto.getStartTime());
//            appointment.setPatientName(appointmentDto.getPatientName());
//
//            appointmentRepository.save(appointment);
//
//            return ResponseEntity.ok("Запись успешно создана");
//        }
//    }
}

