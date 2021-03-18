package com.example.BMI.repository;

import com.example.BMI.entity.Recipe;

import java.util.List;

public interface RecipeRepository {

    void saveRecipe(Recipe recipe);

    List<Recipe> getRecipes();
}
