package com.vgernsoft.calc.calculator;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorSepDefs extends SpringIntegrationTest {
    Double total;
    Double precision;
    String version;

    @Given("the client uses the \\/api\\/{int}.{int}.{int} with precision {double}")
    public void the_client_uses_the_api(int a, int b, int c, double p) {
        total = 0d;
        version = format("/api/%d.%d.%d/", a, b, c);
        precision = p;
    }

    @When("the client calculates {string}")
    public void the_client_calculates(String expr) {
        total = callCalculatorService(version, expr);
    }

    @Then("the result should be {double}")
    public void the_result_should_be(Double answer) {
        assertEquals(answer, total, precision);
    }
}
