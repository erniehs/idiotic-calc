package com.vgernsoft.calc.calculator;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calcShouldReturnExpr() throws Exception {
        final String expr = "(1+2)/2+(34+6)/9";

        this.mockMvc.perform(get("/calc/" + expr)).andExpect(status().isOk())
                .andExpect(content().string(containsString(expr)));
    }
}
