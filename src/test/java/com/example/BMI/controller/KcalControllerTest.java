package com.example.BMI.controller;

import com.example.BMI.entity.Kcal;
import com.example.BMI.service.KcalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(KcalController.class)
class KcalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    KcalService service;

    @Test
    void givenExemplaryDataWhenFirstEndpointOfKcalControllerIsMockedThenOutputIsCorrect() throws Exception {

        mockMvc.perform(get("/kcal")).andExpect(view().name("kcal-form"))
                .andExpect(model().attributeExists("kcal"));
    }

    @Test
    void givenExemplaryDataWhenSecondEndpointOfKcalControllerIsMockedThenOutputIsCorrect() throws Exception {

        Kcal kcal = new Kcal();
        double lifestyle = 1.2;
        double solution = 1500.50;
        String result = "1501";

        when(service.lifestyle(kcal.getLifestyleS())).thenReturn(lifestyle);
        when(service.count(kcal.getAge(), kcal.getHeight(), kcal.getMass(), lifestyle, kcal.getGender())).thenReturn(solution);
        when(service.convert(solution)).thenReturn(result);

        mockMvc.perform(post("/solution_kcal")).andExpect(view().name("solution_kcal"))
                .andExpect(model().attribute("kcal", hasProperty("solution", is(result))));

    }
}