package com.spitter.demo.controller;

import com.spitter.demo.dao.SpittleRepository;
import com.spitter.demo.entity.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository repository;

    @Autowired
    public SpittleController(SpittleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String spittle() {
        return "sendspittle";
    }

    @PostMapping
    public String sendSpittle(Spittle spittle) {
        repository.save(spittle);
        repository.flush();
        return "redirect:/spittles/" + spittle.getId();
    }

    @GetMapping("/all")
    public String spittles(Model model, @RequestParam(defaultValue = "20") int count) {
        model.addAttribute("spittles", repository.findSpittles(Long.MAX_VALUE, count));
        return "spittles";
    }

    @GetMapping("/{id}")
    public String spittle(Model model, @PathVariable Long id) {
        Optional<Spittle> op = repository.findById(id);
        if (op.isPresent()) {
            model.addAttribute("spittle", op.get());
            return "spittle";
        }
        else {
            return "error";
        }
    }

}
