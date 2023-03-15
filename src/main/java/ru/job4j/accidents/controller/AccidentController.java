package ru.job4j.accidents.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.service.AccidentService;

@Controller
@AllArgsConstructor
public class AccidentController {
    private final AccidentService accidents;

    @GetMapping("/createAccident")
    public String viewCreateAccident() {
        return "createAccident";
    }

    @PostMapping("/saveAccident")
    public String save(@ModelAttribute Accident accident) {
        accidents.add(accident);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable int id, Model model) {
        var accident = accidents.getById(id);
        model.addAttribute("accident", accident);
        return "/editAccident";
    }

    @PostMapping("/update")
    public String edit(@ModelAttribute Accident accident) {
        accidents.update(accident);
        return "redirect:/";
    }
}