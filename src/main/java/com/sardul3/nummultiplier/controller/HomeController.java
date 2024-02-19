package com.sardul3.nummultiplier.controller;

import com.sardul3.nummultiplier.model.Output;
import com.sardul3.nummultiplier.service.MultiplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private MultiplierService service;

    @GetMapping("/home")
    public String getHomeForm() {
        return "inputForm";
    }

    @PostMapping("/home")
    public String processNumber(@RequestParam("num") int number, Model model) {
        Output result = service.processNumber(number);
        model.addAttribute("doubled", result.getNumberMultiplied());
        model.addAttribute("squaredDoubled", result.getNumberMultipliedSquared());
        return "inputForm";
    }
}
