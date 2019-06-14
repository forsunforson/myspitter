package com.spitter.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserInfoController {
    @GetMapping("/spitter/{username}")
    public String showInfo(Model model, @PathVariable String username) {
        model.addAttribute("spitter", username);
        return "spitter";
    }
}
