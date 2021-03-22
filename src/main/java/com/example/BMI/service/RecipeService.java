package com.example.BMI.service;

import com.example.BMI.entity.Recipe;
import com.example.BMI.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService implements RecipeRepository {

    public RecipeService(){

       Recipe recipe = new Recipe("Vegan", "Marinated tofu", 1);
       Recipe recipe2 = new Recipe("Vegetarian", "Greek salad", 2);
       Recipe recipe3 = new Recipe("Vegetarian", "Rice with strawberries", 3);
       Recipe recipe4 = new Recipe("Meat", "Pasta with chicken, zucchini, feta cheese and sun dried tomatoes", 4);

       saveRecipe(recipe);
       saveRecipe(recipe2);
       saveRecipe(recipe3);
       saveRecipe(recipe4);
    }

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
