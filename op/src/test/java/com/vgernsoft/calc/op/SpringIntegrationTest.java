package com.vgernsoft.calc.op;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.fail;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@WebMvcTest(OpController.class)
@Import(OpConfig.class)
public class SpringIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    Double callOpService(final String version, final String op, final Double a, final Double b) {
        try {
            return parseDouble(mockMvc.perform(get(format("%s/%f/%s/%f", version, a, op, b))).andExpect(status().isOk())
                    .andReturn().getResponse().getContentAsString());
        } catch (Exception e) {
            fail(e);
        }
        return -1d;
    }
}
