package com.medProject.bitlabMed.restApi;

import com.medProject.bitlabMed.dtos.AnalyzesDTO;
import com.medProject.bitlabMed.services.AnalyzesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("analyzes")
public class AnalyzeRestController {

    private final AnalyzesService analyzesService;

    @GetMapping(value = "/getAllAnalyzes")
    public List<AnalyzesDTO> getAllAnalyzes(){
        return analyzesService.getAllAnalyzes();
    }

    @GetMapping(value = "/getAnalyze/{id}")
    public AnalyzesDTO getAnalyze(@PathVariable Long id){
        return analyzesService.getAnalyzeById(id);
    }

    @PostMapping(value = "/addAnalyze")
    public AnalyzesDTO addAnalyze(@RequestBody AnalyzesDTO analyzesDTO){
       return analyzesService.addAnalyze(analyzesDTO);
    }

    @PutMapping(value = "/updateAnalyze")
    public AnalyzesDTO updateAnalyze(@RequestBody AnalyzesDTO analyzesDTO){
        return analyzesService.updateAnalyze(analyzesDTO);
    }

    @DeleteMapping(value = "/deleteAnalyze/{id}")
    public void deleteAnalyzeById(@PathVariable Long id){
        analyzesService.deleteAnalyzeById(id);
    }

    @GetMapping(value = "/getAnalyzesByCategory/{categoryId}")
    public List<AnalyzesDTO> getAnalyzesByCategory(@PathVariable Long categoryId) {
        return analyzesService.findByAnalyzesCategory_Id(categoryId);
    }
}
