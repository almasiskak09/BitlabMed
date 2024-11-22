package com.medProject.bitlabMed.restApi;

import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesDTO;
import com.medProject.bitlabMed.services.AnalyzesService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cart-page")
public class CartRestController {

    private final AnalyzesService analyzesService;

    @PostMapping("/add-to-cart")
    public void addToCart(@RequestParam Long analyzeId, HttpSession httpSession, RedirectAttributes redirectAttributes) {
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
    }

    @PostMapping("/delete-from-cart")
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

    //    @GetMapping("/checkCart")
//    @ResponseBody
//    public Map<String, Boolean> checkCart(@ModelAttribute("cart") List<AnalyzesDTO> cart) {
//        boolean isEmpty = cart == null || cart.isEmpty();
//        return Collections.singletonMap("isEmpty", isEmpty);
//    }

}
