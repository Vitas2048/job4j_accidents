package ru.job4j.accidents.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.service.AccidentService;

@Controller
@AllArgsConstructor
public class IndexController {

    private final AccidentService accidentService;

    @GetMapping("/")
    public String index(Model model) {
        var accident = new Accident();
        accident.setName("ДТП на улице кузова");
        accident.setText("Вчера ночью произошла авария с участием трех машин");
        accident.setAddress("ул. кузова 55");
        var accident2 = new Accident();
        accident.setId(1);
        accident2.setId(2);
        accident2.setName("ДТП на улице Лобово");
        accident2.setText("Вчера утром произошла авария с участием двух машин");
        accident2.setAddress("ул. Лобово 123");
        accidentService.add(accident);
        accidentService.add(accident2);
        model.addAttribute("accidents", accidentService.findAll());
        return "index";
    }
}
