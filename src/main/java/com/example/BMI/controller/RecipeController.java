package com.example.BMI.controller;

import com.example.BMI.entity.Recipe;
import com.example.BMI.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RecipeController {

    @Autowired
    RecipeService service;

    @GetMapping("/recipes")
    public String getRecipes(Model model) {
        List<Recipe> recipes = service.getRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }

    @GetMapping("/recipes/{id}")
    public String getRecipe(@PathVariable("id") int id){
        if(id==1){
            return "recipe1";
        }
        return "recipe2";
    }
}
