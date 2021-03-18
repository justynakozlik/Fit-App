package com.example.BMI.service;

import com.example.BMI.entity.Recipe;
import com.example.BMI.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.List;

public class RecipeService implements RecipeRepository {
    
   List<Recipe> recipes = new ArrayList<>();

    @Override
    public void saveRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
