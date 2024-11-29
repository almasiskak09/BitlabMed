package com.medProject.bitlabMed.services.implementation;


import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesDTO;
import com.medProject.bitlabMed.entities.Analyzes.Analyzes;
import com.medProject.bitlabMed.mappers.AnalyzesMapper;
import com.medProject.bitlabMed.repositories.AnalyzesRepository;
import com.medProject.bitlabMed.services.AnalyzesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AnalyzesServiceImpl implements AnalyzesService  {

    private final AnalyzesRepository analyzesRepository;
    private final AnalyzesMapper analyzesMapper;

    public List<AnalyzesDTO> getAllAnalyzes(){
        List<Analyzes>analyzesList = analyzesRepository.findAll();
        return analyzesMapper.toDtoList(analyzesList);
    }
    public AnalyzesDTO addAnalyze (AnalyzesDTO analyzesDTO){
        Analyzes analyze = analyzesMapper.toEntity(analyzesDTO);
        analyzesRepository.save(analyze);
        return analyzesMapper.toDto(analyze);
    }
    public AnalyzesDTO getAnalyzeById(Long id){
        return analyzesMapper.toDto(analyzesRepository.findById(id).orElseThrow(null));
    }
    public AnalyzesDTO updateAnalyze(AnalyzesDTO analyzesDTO){
        Analyzes analyzes = analyzesMapper.toEntity(analyzesDTO);
        analyzesRepository.save(analyzes);
        return analyzesMapper.toDto(analyzes);
    }
   public void deleteAnalyzeById(Long id){
        analyzesRepository.deleteById(id);
    }

    public List<AnalyzesDTO> findByAnalyzesCategory_Id(Long categoryId) {
        List<Analyzes> analyzes = analyzesRepository.findByAnalyzesCategory_Id(categoryId);
        List<AnalyzesDTO> analyzesDTOList = new ArrayList<>();

        for(Analyzes a1 : analyzes){
            analyzesDTOList.add(analyzesMapper.toDto(a1));
        }
        return analyzesDTOList;
    }

    public String formatPrice(double price) {
        NumberFormat formatter = NumberFormat.getInstance(new Locale("ru", "RU"));
        return formatter.format(price);
    }
    public List<Analyzes>findAllById(List<Long> ids){
        return analyzesRepository.findAllById(ids);
    }


}
