package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesCategoryDTO;
import com.medProject.bitlabMed.entities.Analyzes.AnalyzesCategory;
import com.medProject.bitlabMed.mappers.AnalyzesCategoryMapper;
import com.medProject.bitlabMed.repositories.AnalyzesCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


class AnalyzesCategoryServiceImplTest {

    @InjectMocks
    private AnalyzesCategoryServiceImpl analyzesCategoryService;

    @Mock
    private AnalyzesCategoryRepository analyzesCategoryRepository;

    @Mock
    private AnalyzesCategoryMapper analyzesCategoryMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCategories() {

        AnalyzesCategory analyzesCategory = new AnalyzesCategory();
        AnalyzesCategory analyzesCategory1 = new AnalyzesCategory();

        Mockito.when(analyzesCategoryRepository.findAll()).thenReturn(List.of(analyzesCategory,analyzesCategory1));
        Mockito.when(analyzesCategoryMapper.toDtoList(anyList())).thenReturn(List.of(new AnalyzesCategoryDTO(),new AnalyzesCategoryDTO()));

        List<AnalyzesCategoryDTO> result = analyzesCategoryService.getAllAnalyzesCategory();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testAddAnalyzesCategory(){

        AnalyzesCategoryDTO dto = new AnalyzesCategoryDTO();
        AnalyzesCategory entity = new AnalyzesCategory();

        Mockito.when(analyzesCategoryMapper.toEntity(dto)).thenReturn(entity);
        Mockito.when(analyzesCategoryRepository.save(entity)).thenReturn(entity);
        Mockito.when(analyzesCategoryMapper.toDTO(entity)).thenReturn(dto);

        AnalyzesCategoryDTO result = analyzesCategoryService.addAnalyzeCategory(dto);

        assertNotNull(result);
    }

    @Test
    void testGetAnalyzesCategoryById(){

        Long id = 1L;
        AnalyzesCategory entity = new AnalyzesCategory();

        Mockito.when(analyzesCategoryRepository.findById(id)).thenReturn(Optional.of(entity));
        Mockito.when(analyzesCategoryMapper.toDTO(entity)).thenReturn(new AnalyzesCategoryDTO());

        AnalyzesCategoryDTO result = analyzesCategoryService.getAnalyzeCategoryById(id);
        assertNotNull(result);
    }

    @Test
    void testDeleteAnalyzesCategoryById(){
        Long id = 1L;

        analyzesCategoryService.deleteAnalyzeCategoryById(id);
        verify(analyzesCategoryRepository, times(1)).deleteById(id);

    }

}