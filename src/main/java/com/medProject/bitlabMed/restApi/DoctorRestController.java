package com.medProject.bitlabMed.restApi;

import com.medProject.bitlabMed.dtos.DoctorDto.DoctorDTO;
import com.medProject.bitlabMed.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/doctors")
public class DoctorRestController {

    private final DoctorService doctorService;

    @GetMapping(value = "/getAllDoctors")
    public List<DoctorDTO> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping(value = "/getDoctor/{id}")
    public DoctorDTO getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }

    @PostMapping(value = "/addDoctor")
    public DoctorDTO addDoctor(@RequestBody DoctorDTO doctorDto){
        return doctorService.addDoctor(doctorDto);
    }

    @PutMapping(value = "/updateDoctor")
    public DoctorDTO updateDoctor(@RequestBody DoctorDTO doctorDto){
        return doctorService.updateDoctor(doctorDto);
    }

    @DeleteMapping(value = "/deleteDoctor/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.deleteCarById(id);
    }

    @GetMapping(value = "getDoctorBySpeciality/{speciality}")
    public List<DoctorDTO> getDoctorBySpeciality(@PathVariable String speciality){
        return doctorService.getDoctorsBySpeciality(speciality);
    }

}
