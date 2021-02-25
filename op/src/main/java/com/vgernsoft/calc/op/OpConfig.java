package com.vgernsoft.calc.op;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpConfig {

    @Bean
    public Map<String, String> opMap() {
        return Map.of("add", "+", "sub", "-", "mul", "*", "div", "/");
    }
}
