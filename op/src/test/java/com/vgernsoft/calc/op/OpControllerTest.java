package com.vgernsoft.calc.op;

import static java.lang.String.format;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(OpController.class)
public class OpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calcIntegerShouldReturnValidResult() throws Exception {
        final String a = "5";
        final String b = "6";
        this.mockMvc.perform(get("/api/1.0.0/" + a + "/+/" + b)).andExpect(status().isOk())
                .andExpect(content().string(containsString(Double.toString(11.0))));
    }

    @Test
    public void calcFloatShouldReturnValidResult() throws Exception {
        final String a = "5.7";
        final String b = "-6";
        this.mockMvc.perform(get("/api/1.0.0/" + a + "/+/" + b)).andExpect(status().isOk())
                .andExpect(content().string(containsString(Double.toString(5.7 + -6))));
    }
}
