package com.example.BMI.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BMIServiceTest {

    static BMIService service;
    static double solution;

    @BeforeAll
    static void init(){
        service = new BMIService();
        solution = 23.536;
    }

    @Test
    void givenExemplarySolutionWhenInfoMethodIsUsedThenInformationIsCorrect(){
        String information = service.info(solution);
        Assertions.assertTrue(information.equals("Correct body weight"));
    }

    @Test
    void givenExemplarySolutionWhenInfoMethodIsUsedThenInformationIsNotCorrect(){
        String information = service.info(solution);
        Assertions.assertFalse(information.equals("Underweight"));
    }

    @Test
    void givenExemplarySolutionWhenConvertMethodIsUsedThenOutputHasCorrectFormat(){
        String output = service.convert(solution);
        Assertions.assertEquals(output,"23,54");
    }

    @Test
    void givenExemplaryHeightAndMassWhenCountMethodIsUsedThenSolutionIsCorrect(){
        double height = 1.73;
        double mass = 52.5;
        double solution = service.count(height, mass);
        Assertions.assertEquals(17.541514918640782, solution);
    }

}