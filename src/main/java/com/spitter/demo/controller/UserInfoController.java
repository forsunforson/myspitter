package com.spitter.demo.controller;

import com.spitter.demo.dao.SpitterRepository;
import com.spitter.demo.entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author wye
 */
@Controller
public class UserInfoController {
    private SpitterRepository repository;

    @Autowired
    UserInfoController(SpitterRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/spitter/id/{id}")
    public String showInfo(Model model, @PathVariable Long id) {
        Optional<Spitter> flag = repository.findById(id);
        if (flag.isPresent()) {
            Spitter spitter = flag.get();
            model.addAttribute("spitter", spitter.getUsername());
            model.addAttribute("userId", spitter.getId());
            return "spitter";
        }
        else {
            return "error";
        }
    }

    @GetMapping("/spitter/user/{username}")
    public String showInfo(Model model, @PathVariable String username) {
        Spitter spitter = repository.findByUsername(username);
        if (spitter == null) {
            return "error";
        }
        else {
            model.addAttribute("spitter", spitter.getUsername());
            model.addAttribute("userId", spitter.getId());
            return "spitter";
        }
    }
}
