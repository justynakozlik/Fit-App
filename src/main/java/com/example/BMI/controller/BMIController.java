package com.example.BMI.controller;

import com.example.BMI.entity.BMI;
import com.example.BMI.service.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BMIController {

    @Autowired
    BMIService service;

    @GetMapping("/bmi")
    public String bmiForm(Model model){
        model.addAttribute("bmi", new BMI());
        return "bmi-form";
    }

    @PostMapping("/solution")
    public String solution(BMI bmi, Model model) {
        double solution = service.count(bmi.getHeight(),bmi.getMass());
        String output = service.convert(solution);
        bmi.setSolution(output);
        String information = service.info(solution);
        bmi.setInformation(information);
        model.addAttribute("bmi", bmi);
        return "solution";
    }
}
