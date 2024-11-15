package com.medProject.bitlabMed.restApi;

import com.medProject.bitlabMed.dtos.DiagnosticDTO;
import com.medProject.bitlabMed.services.DiagnosticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("diagnostic")
public class DiagnosticRestController {

    private final DiagnosticService diagnosticService;

    @GetMapping(value = "/getAllDiagnostics")
    public List<DiagnosticDTO> getAllDiagnostics(){
        return diagnosticService.getAllDiagnostics();
    }

    @GetMapping(value = "/getDiagnostic/{id}")
    public DiagnosticDTO getDiagnosticById(@PathVariable Long id){
        return diagnosticService.getDiagnosticById(id);
    }

    @PostMapping(value = "/addDiagnostic")
    public DiagnosticDTO addDiagnostic(@RequestBody DiagnosticDTO diagnosticDTO){
        return diagnosticService.addDiagnostic(diagnosticDTO);
    }

    @PutMapping(value = "/updateDiagnostic")
    public DiagnosticDTO updateDiagnostic(@RequestBody DiagnosticDTO diagnosticDTO){
       return diagnosticService.updateDiagnostic(diagnosticDTO);
    }

    @DeleteMapping(value = "/deleteDiagnostic")
    public void deleteDiagnostic(Long id){
        diagnosticService.deleteDiagnosticById(id);
    }


}
