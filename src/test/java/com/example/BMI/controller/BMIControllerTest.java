package com.example.BMI.controller;

import com.example.BMI.entity.BMI;
import com.example.BMI.service.BMIService;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
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

@WebMvcTest(BMIController.class)
class BMIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BMIService service;

    @Test
    void givenExemplaryDataWhenFirstEndpointOfBMIControllerIsMockedThenOutputIsCorrect() throws Exception {

        mockMvc.perform(get("/bmi")).andExpect(view().name("bmi-form"))
                .andExpect(model().attributeExists("bmi"));
    }

    @Test
    void givenExemplaryDataWhenSecondEndpointOfBMIControllerIsMockedThenOutputIsCorrect() throws Exception {

        BMI bmi = new BMI();
        double solution = 23.559;
        String output = "23,56";
        String information = "Correct body mass";

        when(service.count(bmi.getHeight(), bmi.getMass())).thenReturn(solution);
        when(service.convert(solution)).thenReturn(output);
        when(service.info(solution)).thenReturn(information);

        mockMvc.perform(post("/solution")).andExpect(view().name("solution"))
                .andExpect(model().attribute("bmi", hasProperty("solution", is(output))))
                .andExpect(model().attribute("bmi", hasProperty("information", is(information))));


    }

}