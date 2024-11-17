package com.medProject.bitlabMed.controllers;

import com.medProject.bitlabMed.dtos.AnalyzesDTO;
import com.medProject.bitlabMed.services.AnalyzesService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final AnalyzesService analyzesService;

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam Long analyzeId, HttpSession httpSession, RedirectAttributes redirectAttributes) {
        List<AnalyzesDTO> cart = (List<AnalyzesDTO>) httpSession.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            httpSession.setAttribute("cart", cart);
        }

        AnalyzesDTO analyzesDTO = analyzesService.getAnalyzeById(analyzeId);
        if (analyzesDTO != null) {
            cart.add(analyzesDTO);
        }

        List<Long> addedAnalyzes = (List<Long>) httpSession.getAttribute("addedAnalyzes");
        if (addedAnalyzes == null) {
            addedAnalyzes = new ArrayList<>();
            httpSession.setAttribute("addedAnalyzes", addedAnalyzes);
        }
        addedAnalyzes.add(analyzeId);

        return "redirect:/cart";
    }

    @PostMapping("/delete-from-cart")
    @ResponseBody
    public Map<String, Object> deleteFromCart(@RequestParam Long analyzeId, HttpSession session) {
        List<AnalyzesDTO> cart = (List<AnalyzesDTO>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(analyze -> analyze.getId().equals(analyzeId));
        }

        // Обновляем список addedAnalyzes
        List<Long> addedAnalyzes = (List<Long>) session.getAttribute("addedAnalyzes");
        if (addedAnalyzes != null) {
            addedAnalyzes.remove(analyzeId);
        }

        // Вычисляем общую сумму
        double totalPrice = cart.stream().mapToDouble(AnalyzesDTO::getAnalyzesPrice).sum();

        // Возвращаем JSON-ответ с обновленной общей суммой
        Map<String, Object> response = new HashMap<>();
        response.put("totalPrice", totalPrice);
        return response;
    }


    @GetMapping("/cart")
    public String getCart(HttpSession httpSession, Model model) {
        List<AnalyzesDTO> cart = (List<AnalyzesDTO>) httpSession.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            httpSession.setAttribute("cart", cart);
        }

        int totalPrice = 0;
        for (AnalyzesDTO cart1 : cart) {
            totalPrice += cart1.getAnalyzesPrice();
        }
        model.addAttribute("cart", cart);
        model.addAttribute("totalPrice", totalPrice);

        return "cart";
    }

    @GetMapping("/checkCart")
    @ResponseBody
    public Map<String, Boolean> checkCart(@ModelAttribute("cart") List<AnalyzesDTO> cart) {
        boolean isEmpty = cart == null || cart.isEmpty();
        return Collections.singletonMap("isEmpty", isEmpty);
    }

}
