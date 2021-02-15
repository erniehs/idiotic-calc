package com.vgernsoft.calc.calculator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
class CalculatorController {

    @GetMapping("/calc/**")
    public ResponseEntity<String> calc(HttpServletRequest httpServletRequest) {
        final String expr = httpServletRequest.getRequestURI().split("/calc/")[1];
        log.debug("expr {}", expr);
        return new ResponseEntity<String>(expr, HttpStatus.OK);
    }
}