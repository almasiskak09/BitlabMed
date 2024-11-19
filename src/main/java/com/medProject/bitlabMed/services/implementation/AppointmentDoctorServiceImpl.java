package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.dtos.DoctorDto.AppointmentDoctorDto;
import com.medProject.bitlabMed.entities.Doctor.AppointmentDoctor;
import com.medProject.bitlabMed.mappers.AppointmentDoctorMapper;
import com.medProject.bitlabMed.repositories.AppointmentDoctorRepository;
import com.medProject.bitlabMed.services.AppointmentDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AppointmentDoctorServiceImpl implements AppointmentDoctorService {

    private final AppointmentDoctorRepository appointmentDoctorRepository;
    private final AppointmentDoctorMapper appointmentDoctorMapper;

    public Map<LocalDate, List<LocalTime>> getWeekSchedule(Long doctorId, LocalDate startDate) {
        LocalDate endDate = startDate.plusDays(7); // Неделя
        List<AppointmentDoctor> appointments = appointmentDoctorRepository.findByDoctorIdAndAppointmentDateBetween(doctorId, startDate, endDate);

        // Все временные слоты для одного дня
        List<LocalTime> allSlots = generateHourlySlots(LocalTime.of(10, 0), LocalTime.of(18, 0));

        // Группировка записей по дате
        Map<LocalDate, List<LocalTime>> occupiedSlotsByDate = new HashMap<>();
        for (AppointmentDoctor appointment : appointments) {
            occupiedSlotsByDate
                    .computeIfAbsent(appointment.getAppointmentDate(), k -> new ArrayList<>())
                    .add(appointment.getAppointmentStartTime());
        }

        // Генерация расписания на неделю
        Map<LocalDate, List<LocalTime>> schedule = new HashMap<>();
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            List<LocalTime> availableSlots = new ArrayList<>();
            List<LocalTime> occupiedSlots = occupiedSlotsByDate.getOrDefault(date, List.of());
            for (LocalTime slot : allSlots) {
                if (!occupiedSlots.contains(slot)) {
                    availableSlots.add(slot);
                }
            }
            schedule.put(date, availableSlots);
        }

        return schedule;
    }

    private List<LocalTime> generateHourlySlots(LocalTime start, LocalTime end) {
        List<LocalTime> slots = new ArrayList<>();
        while (!start.isAfter(end.minusHours(1))) {
            slots.add(start);
            start = start.plusHours(1);
        }
        return slots;
    }

    //CRUD
    public List<AppointmentDoctorDto> getAllAppointmentDoctorsList(){
        List<AppointmentDoctor> appointments = appointmentDoctorRepository.findAll();
      return   appointmentDoctorMapper.toDtoList(appointments);
    }
    public AppointmentDoctorDto addAppointmentDoctor ( AppointmentDoctorDto appointmentDoctorDto){
        AppointmentDoctor appointmentDoctor = appointmentDoctorMapper.toEntity(appointmentDoctorDto);
        appointmentDoctor.setBooked(true);
        appointmentDoctorRepository.save(appointmentDoctor);
        return appointmentDoctorMapper.toDto(appointmentDoctor);
    }
    public AppointmentDoctorDto getAppointmentDoctorById(Long id){
        AppointmentDoctor appointmentDoctor = appointmentDoctorRepository.findById(id).orElseThrow(null);
        return appointmentDoctorMapper.toDto(appointmentDoctor);
    }
    public AppointmentDoctorDto updateAppointmentDoctor(AppointmentDoctorDto appointmentDoctorDto){
        AppointmentDoctor appointmentDoctor = appointmentDoctorMapper.toEntity(appointmentDoctorDto);
        appointmentDoctorRepository.save(appointmentDoctor);
        return appointmentDoctorMapper.toDto(appointmentDoctor);
    }
    public void deleteAppointmentDoctor(Long id){
        appointmentDoctorRepository.deleteById(id);
    }
}
