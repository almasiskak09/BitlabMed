package com.medProject.bitlabMed.restApi;

import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesDTO;
import com.medProject.bitlabMed.dtos.AnalyzesDto.ApplicationAnalyzesDTO;
import com.medProject.bitlabMed.entities.User.User;
import com.medProject.bitlabMed.repositories.UserRepository;
import com.medProject.bitlabMed.services.ApplicationAnalyzesService;
import com.medProject.bitlabMed.services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/application-analyzes")
public class ApplicationAnalyzesRestController {

    private final ApplicationAnalyzesService applicationAnalyzesService;
    private final UserRepository userRepository;

    @GetMapping(value = "/getAllApplicationAnalyzes")
    public List<ApplicationAnalyzesDTO> getAllApplicationAnalyzes(){
        return applicationAnalyzesService.getAllApplicationAnalyzes();
    }

    @PostMapping(value = "/addApplication")
    public ApplicationAnalyzesDTO addApplication(Model model, @RequestBody ApplicationAnalyzesDTO applicationAnalyzesDTO, HttpSession httpSession) {

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
        System.out.println(applicationAnalyzesDTO.getApUserFullName());

        //очищаем корзину
        List<AnalyzesDTO> cart = (List<AnalyzesDTO>) httpSession.getAttribute("cart");
        cart.clear();
        model.addAttribute("cart", cart);
        List<Long> addedAnalyzes = (List<Long>) httpSession.getAttribute("addedAnalyzes");
        addedAnalyzes.clear();
        model.addAttribute("addedAnalyzes", addedAnalyzes);


        return applicationAnalyzesDTO;
    }

    @DeleteMapping(value = "/deleteApplicationAnalyzes/{id}")
    public void deleteApplicationAnalyzes(Long id, HttpSession httpSession) {
        applicationAnalyzesService.deleteApplicationAnalyzesById(id);
    }
}
