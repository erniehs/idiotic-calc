package com.vgernsoft.calc.op;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import com.vgernsoft.calc.common.Op;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(OpController.class)
@Import(OpConfig.class)
public class OpControllerTest {

    @Autowired
    private Map<String, String> opMap;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calcIntegerShouldReturnValidResult() throws Exception {
        final String a = "5";
        final String b = "6";
        for (String op : opMap.keySet()) {
            this.mockMvc.perform(get("/api/1.0.0/" + a + "/" + op + "/" + b)).andExpect(status().isOk())
                    .andExpect(content().string(containsString(
                            Double.toString(Op.exec(opMap.get(op), Double.parseDouble(a), Double.parseDouble(b))))));
        }
    }

    @Test
    public void calcFloatShouldReturnValidResult() throws Exception {
        final String a = "5.7";
        final String b = "-6";
        for (String op : opMap.keySet()) {
            this.mockMvc.perform(get("/api/1.0.0/" + a + "/" + op + "/" + b)).andExpect(status().isOk())
                    .andExpect(content().string(containsString(
                            Double.toString(Op.exec(opMap.get(op), Double.parseDouble(a), Double.parseDouble(b))))));
        }
    }
}
