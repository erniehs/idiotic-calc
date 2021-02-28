package com.vgernsoft.calc.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@WebMvcTest(CalculatorController.class)
public class SpringIntegrationTest {

    @Autowired
    MockMvc mockMvc;
}
