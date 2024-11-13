package com.medProject.bitlabMed.restApi;

import com.medProject.bitlabMed.dtos.AnalyzesCategoryDTO;
import com.medProject.bitlabMed.services.AnalyzesCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("analyze-category")
public class AnalyzeCategoryRestController {

    private final AnalyzesCategoryService analyzesCategoryService;

    @GetMapping(value = "/getAllAnalyzesCategories")
    public List<AnalyzesCategoryDTO> getAnalyzesCategories() {
        return analyzesCategoryService.getAllAnalyzesCategory();
    }

    @GetMapping(value = "/getAnalyzesCategory/{id}")
    public AnalyzesCategoryDTO getAnalyzesCategory(@PathVariable Long id) {
        return analyzesCategoryService.getAnalyzeCategoryById(id);
    }

    @PostMapping(value = "/addAnalyzesCategory")
    public AnalyzesCategoryDTO addAnalyzesCategory(@RequestBody AnalyzesCategoryDTO analyzesCategoryDTO) {
        return analyzesCategoryService.addAnalyzeCategory(analyzesCategoryDTO);
    }

    @PutMapping(value = "/updateAnalyzesCategory")
    public AnalyzesCategoryDTO updateAnalyzesCategory(@RequestBody AnalyzesCategoryDTO analyzesCategoryDTO) {
        return analyzesCategoryService.updateAnalyzeCategory(analyzesCategoryDTO);
    }

    @DeleteMapping(value = "/deleteAnalyzesCategory/{id}")
    public void deleteAnalyzesCategory(@PathVariable Long id) {
        analyzesCategoryService.deleteAnalyzeCategoryById(id);
    }
}
