package com.example.BMI.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KcalServiceTest {

    static KcalService service;
    static int age;
    static int height;
    static double mass;
    static double lifestyle;
    static String gender;

    @BeforeAll
    static void init(){
        service = new KcalService();
        age = 24;
        height = 170;
        mass = 70;
        lifestyle = 1.0;
        gender = "male";
    }

    @Test
    void givenExemplaryStringWhenLifestyleMethodIsUsedThenCorrectDoubleIsReturned(){
        double a = service.lifestyle("a");
        Assertions.assertTrue(a == 1.0);
    }

    @Test
    void givenExemplaryParametersAndMaleGenderWhenCountMethodIsUsedThenCorrectFormulaIsReturned(){
        double count = service.count(age, height, mass, lifestyle, gender);
        Assertions.assertTrue(count == 1712.3);
    }

    @Test
    void givenExemplaryParametersAndFemaleGenderWhenCountMethodIsUsedThenCorrectFormulaIsReturned(){
        double count = service.count(age, height, mass, lifestyle, "female");
        Assertions.assertTrue(count == 939.2);
    }

    @Test
    void givenExemplarySolutionWhenConvertMethodIsUsedThenFormatOfSolutionIsCorrect(){
        String convert = service.convert(2060.54);
        Assertions.assertEquals(convert, "2061");
    }
}