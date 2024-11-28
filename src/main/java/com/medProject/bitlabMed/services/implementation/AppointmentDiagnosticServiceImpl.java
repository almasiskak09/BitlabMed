package com.medProject.bitlabMed.services.implementation;


import com.medProject.bitlabMed.dtos.DiagnosticDto.AppointmentDiagnosticDto;
import com.medProject.bitlabMed.entities.Diagnostic.AppointmentDiagnostic;
import com.medProject.bitlabMed.mappers.AppointmentDiagnosticMapper;
import com.medProject.bitlabMed.repositories.AppointmentDiagnosticRepository;
import com.medProject.bitlabMed.services.AppointmentDiagnosticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentDiagnosticServiceImpl implements AppointmentDiagnosticService {

    private final AppointmentDiagnosticRepository appointmentDiagnosticRepository;
    private final AppointmentDiagnosticMapper appointmentDiagnosticMapper;

    public List<AppointmentDiagnosticDto> getAllAppointmentDiagnosticList(){
        List<AppointmentDiagnostic> appointmentDiagnostics = appointmentDiagnosticRepository.findAll();
        return appointmentDiagnosticMapper.toDtoList(appointmentDiagnostics);
    }
    public AppointmentDiagnosticDto addAppointmentDiagnostic ( AppointmentDiagnosticDto appointmentDiagnosticDto){
        AppointmentDiagnostic appointmentDiagnostic = appointmentDiagnosticMapper.toEntity(appointmentDiagnosticDto);
        appointmentDiagnosticRepository.save(appointmentDiagnostic);
        return appointmentDiagnosticMapper.toDto(appointmentDiagnostic);

    }
    public AppointmentDiagnosticDto getAppointmentDiagnosticById(Long id){
        AppointmentDiagnostic appointmentDiagnostic = appointmentDiagnosticRepository.findById(id).orElse(null);
        return appointmentDiagnosticMapper.toDto(appointmentDiagnostic);
    }
    public AppointmentDiagnosticDto updateAppointmentDiagnostic(Long id){
        AppointmentDiagnostic appointmentDiagnostic = appointmentDiagnosticRepository.findById(id).orElse(null);
        appointmentDiagnostic.setHandled(true);
        appointmentDiagnosticRepository.save(appointmentDiagnostic);
        return appointmentDiagnosticMapper.toDto(appointmentDiagnostic);
    }
    public void deleteAppointmentDiagnosticById(Long id){
        appointmentDiagnosticRepository.deleteById(id);
    }

    public List<AppointmentDiagnosticDto> getAppointmentDiagnosticsByUserId(Long userId){
        List<AppointmentDiagnosticDto> appointmentDiagnosticDtoList = appointmentDiagnosticMapper.toDtoList(appointmentDiagnosticRepository.findAllByUserId(userId));
        return appointmentDiagnosticDtoList;
    }

}
