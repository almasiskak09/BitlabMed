package com.medProject.bitlabMed.controllers;

import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesDTO;
import com.medProject.bitlabMed.dtos.AnalyzesDto.ApplicationAnalyzesDTO;
import com.medProject.bitlabMed.entities.User.User;
import com.medProject.bitlabMed.repositories.UserRepository;
import com.medProject.bitlabMed.services.ApplicationAnalyzesService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationAnalyzesService applicationAnalyzesService;
    private final UserRepository userRepository;

    @PostMapping(value = "/addApplication")
    public String addApplication(Model model,@ModelAttribute ApplicationAnalyzesDTO applicationAnalyzesDTO, HttpSession httpSession) {

        if (applicationAnalyzesDTO.getApCreatedDate() == null) {
            applicationAnalyzesDTO.setApCreatedDate(LocalDate.now());
        }

        // Получение текущего пользователя через SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() &&
                !(authentication instanceof AnonymousAuthenticationToken)) {
            // Пользователь залогинен
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userRepository.findByEmail(userDetails.getUsername()); // Поиск пользователя в базе
            if (user != null) {
                // Установка ID пользователя
                applicationAnalyzesDTO.setUserId(user.getId());
            }
        }


        applicationAnalyzesService.addApplicationAnalyzes(applicationAnalyzesDTO);


        //очищаем корзину
        List<AnalyzesDTO> cart = (List<AnalyzesDTO>) httpSession.getAttribute("cart");
        cart.clear();
        model.addAttribute("cart", cart);
        List<Long> addedAnalyzes = (List<Long>) httpSession.getAttribute("addedAnalyzes");
        addedAnalyzes.clear();
        model.addAttribute("addedAnalyzes", addedAnalyzes);


        return "redirect:/cart?success=true";
    }

}
