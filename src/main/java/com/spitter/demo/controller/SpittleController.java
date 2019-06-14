package com.spitter.demo.controller;

import com.spitter.demo.dao.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository repository;

    @Autowired
    public SpittleController(SpittleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public String spittles(Model model, @RequestParam(defaultValue = "20") int count) {
        model.addAttribute("spittles", repository.findSpittles(Long.MAX_VALUE, count));
        return "spittles";
    }

    @GetMapping("/{id}")
    public String spittle(Model model, @PathVariable long id) {
        model.addAttribute("spittle", repository.findById(id));
        return "spittle";
    }
}
