package com.medProject.bitlabMed.restApi;

import com.medProject.bitlabMed.dtos.DiagnosticCategoryDTO;
import com.medProject.bitlabMed.services.DiagnosticCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("diagnostic-category")
public class DiagnosticCategoryRestController {

    private final DiagnosticCategoryService diagnosticCategoryService;

    @GetMapping(value = "/getAllDiagnosticsCategory")
    public List<DiagnosticCategoryDTO> getAllDiagnosticsCategory(){
        return diagnosticCategoryService.getAllDiagnosticsCategory();
    }

    @GetMapping(value = "/getDiagnosticCategory/{id}")
    public DiagnosticCategoryDTO getDiagnosticCategoryById(@PathVariable Long id){
        return diagnosticCategoryService.getDiagnosticCategoryById(id);
    }

    @PostMapping(value = "/addDiagnosticCategory")
    public DiagnosticCategoryDTO addDiagnosticCategory(@RequestBody DiagnosticCategoryDTO diagnosticCategoryDTO){
        return diagnosticCategoryService.addDiagnosticCategory(diagnosticCategoryDTO);
    }

    @PutMapping(value = "/updateDiagnosticCategory")
    public DiagnosticCategoryDTO updateDiagnosticCategory(@RequestBody DiagnosticCategoryDTO diagnosticCategoryDTO){
       return diagnosticCategoryService.updateDiagnosticCategory(diagnosticCategoryDTO);
    }

    @DeleteMapping(value = "/deleteDiagnosticCategory")
    public void deleteDiagnosticCategory(@PathVariable Long id){
        diagnosticCategoryService.deleteDiagnosticCategoryById(id);
    }

}
