package com.vgernsoft.calc.calculator;

import static org.junit.jupiter.api.Assertions.fail;
import static java.lang.String.format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@WebMvcTest(CalculatorController.class)
public class SpringIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    Double callCalculatorService(final String version, final String expr) {
        try {
            return Double.parseDouble(mockMvc.perform(get(format("%s/calc/%s", version, expr)))
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
        } catch (Exception e) {
            fail(e);
        }
        return -1d;
    }
}
