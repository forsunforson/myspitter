package com.spitter.demo.controller;

import com.spitter.demo.dao.SpitterRepository;
import com.spitter.demo.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/spitter")
public class RegisterController {

    private SpitterRepository repository;

    @Autowired
    public RegisterController(SpitterRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/register")
    public String showForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registration(Spitter spitter) {
        Spitter flag = repository.save(spitter);
        repository.flush();
        if (flag != null) {
            return "redirect:/spitter/id/" + spitter.getId();
        }
        else {
            return "redirect:/spitter/register";
        }
    }
}
