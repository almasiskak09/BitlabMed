package com.medProject.bitlabMed.restApi;

import com.medProject.bitlabMed.dtos.DiagnosticDto.AppointmentDiagnosticDto;
import com.medProject.bitlabMed.entities.User.User;
import com.medProject.bitlabMed.repositories.UserRepository;
import com.medProject.bitlabMed.services.AppointmentDiagnosticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/appointment-diagnostic")
@RequiredArgsConstructor
public class AppointmentDiagnosticRestController {

    private final AppointmentDiagnosticService appointmentDiagnosticService;
    private final UserRepository userRepository;

    @GetMapping(value = "/getAllApplicationDiagnostic")
    public List<AppointmentDiagnosticDto> appointmentDiagnosticDtoList(){
        return appointmentDiagnosticService.getAllAppointmentDiagnosticList();
    }
    @GetMapping(value = "/getAppointmentDiagnosticById/{id}")
    public AppointmentDiagnosticDto appointmentDiagnosticDtoById(@PathVariable Long id){
        AppointmentDiagnosticDto appointmentDiagnosticDto = appointmentDiagnosticService.getAppointmentDiagnosticById(id);
        return appointmentDiagnosticDto;
    }

    @PostMapping(value = "/addAppointmentDiagnostic")
    public ResponseEntity<?> addAppointmentDiagnostic(@RequestBody AppointmentDiagnosticDto appointmentDiagnosticDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() &&
                !(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userRepository.findByEmail(userDetails.getUsername());
            if (user != null) {
                appointmentDiagnosticDto.setUserId(user.getId());
            }
        }

        appointmentDiagnosticService.addAppointmentDiagnostic(appointmentDiagnosticDto);
        System.out.println(appointmentDiagnosticDto.getDiagnosticId());
        System.out.println(appointmentDiagnosticDto.getPatientFullName());
        System.out.println(appointmentDiagnosticDto.getPatientPhone());

        // Возвращаем успешный ответ
        return ResponseEntity.ok("Appointment saved successfully");
    }

    @DeleteMapping(value = "/deleteAppointmentDiagnostic/{id}")
    public void deleteAppointmentDiagnostic(@PathVariable Long id) {
        appointmentDiagnosticService.deleteAppointmentDiagnosticById(id);
    }

}


