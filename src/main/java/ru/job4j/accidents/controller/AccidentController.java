package ru.job4j.accidents.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.Rule;
import ru.job4j.accidents.service.AccidentService;
import ru.job4j.accidents.service.AccidentTypeService;
import ru.job4j.accidents.service.RuleService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class AccidentController {
    private final AccidentService accidentService;

    private final RuleService ruleService;

    private final AccidentTypeService accidentTypeService;

    @GetMapping("/formUpdateAccident")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidentService.getById(id).get());
        model.addAttribute("types", accidentTypeService.getAllTypes());
        model.addAttribute("rules", ruleService.getAllRules());
        return "/formUpdateAccident";
    }

    @PostMapping("/updateAccident")
    public String saveAccident(@ModelAttribute Accident accident) {
        accidentService.save(accident);
        return "redirect:/";
    }

    @GetMapping("/createAccident")
    public String viewCreateAccident(Model model) {
        model.addAttribute("types", accidentTypeService.getAllTypes());
        model.addAttribute("rules", ruleService.getAllRules());
        return "createAccident";
    }

    @PostMapping("/saveAccident")
    public String save(@ModelAttribute Accident accident, @RequestParam("rIds")List<Integer> ids) {
        accident.setRules((Set<Rule>) ids.stream().map(ruleService::getById).collect(Collectors.toSet()));
        accidentService.save(accident);
        return "redirect:/";
    }

    @GetMapping("/editAccident")
    public String getEditPage(@ModelAttribute Accident accident) {
        accidentService.save(accident);
        return "/editAccident";
    }

    @PostMapping("/update")
    public String edit(@ModelAttribute Accident accident) {
        accidentService.save(accident);
        return "redirect:/";
    }
}