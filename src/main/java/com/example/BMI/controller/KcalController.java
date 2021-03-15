package com.example.BMI.controller;

import com.example.BMI.entity.Kcal;
import com.example.BMI.service.KcalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KcalController {

    @Autowired
    KcalService service;

    @GetMapping("/kcal")
    public String kcalForm(Model model){
        Kcal kcal = new Kcal();
        kcal.setGender("male");
        kcal.setLifestyleS("a");
        model.addAttribute("kcal", kcal);
        return "kcal-form";
    }

    @PostMapping("/solution_kcal")
    public String solution(Kcal kcal, Model model) {
        double lifestyle = service.lifestyle(kcal.getLifestyleS());
        double count = service.count(kcal.getAge(), kcal.getHeight(), kcal.getMass(), lifestyle, kcal.getGender());
        String convert = service.convert(count);
        kcal.setSolution(convert);
        model.addAttribute("kcal", kcal);
        return "solution_kcal";
    }
}
