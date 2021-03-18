package com.example.BMI.controller;

import com.example.BMI.entity.Recipe;
import com.example.BMI.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecipeController.class)
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RecipeService service;

    @Test
    void givenExemplaryDataWhenFirstEndpointOfRecipeControllerIsMockedThenOutputIsCorrect() throws Exception {

        Recipe recipe = new Recipe("Vegan", "name1", 1);
        Recipe recipe2 = new Recipe("With meat", "name2", 2);

        List<Recipe> recipes = new ArrayList<>();

        recipes.add(recipe);
        recipes.add(recipe2);

        when(service.getRecipes()).thenReturn(recipes);

        mockMvc.perform(get("/recipes")).andExpect(view().name("recipes"))
                .andExpect(model().attribute("recipes", hasItem(
                        allOf(
                                hasProperty("category", is("Vegan")),
                                hasProperty("name", is("name1")),
                                hasProperty("id", is(1))

                        )
                )))
                .andExpect(model().attribute("recipes", hasItem(
                        allOf(
                                hasProperty("category", is("With meat")),
                                hasProperty("name", is("name2")),
                                hasProperty("id", is(2))

                        )
                )));
    }

    @Test
    void givenExemplaryDataWhenSecondEndpointOfRecipeControllerIsMockedThenOutputIsCorrect() throws Exception {

        mockMvc.perform(get("/recipes/1")).andExpect(view().name("recipe1"));
    }
}