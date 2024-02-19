package com.sardul3.nummultiplier.controller;

import com.sardul3.nummultiplier.model.Output;
import com.sardul3.nummultiplier.service.MultiplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller class for handling requests related to number multiplication.
 */
@Controller
public class HomeController {

    final private MultiplierService service;

    /**
     * Constructor for HomeController.
     *
     * @param service MultiplierService instance to be used for processing numbers.
     */
    public HomeController(MultiplierService service) {
        this.service = service;
    }

    /**
     * Handles GET requests for the home page.
     *
     * @return The name of the Thymeleaf template for the home page.
     */
    @GetMapping("/home")
    public String getHomeForm() {
        return "inputForm";
    }

    /**
     * Handles POST requests for processing a number.
     *
     * @param number The number to be processed.
     * @param model  The model to add attributes for the result.
     * @return The name of the Thymeleaf template for the home page.
     */
    @PostMapping("/home")
    public String processNumber(@RequestParam("num") int number, Model model) {
        Output result = service.processNumber(number);
        model.addAttribute("doubled", result.getNumberMultiplied());
        model.addAttribute("squaredDoubled", result.getNumberMultipliedSquared());
        return "inputForm";
    }
}
