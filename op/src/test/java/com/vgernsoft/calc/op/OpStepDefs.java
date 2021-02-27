package com.vgernsoft.calc.op;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpStepDefs extends SpringIntegrationTest {

    Double total;
    Double precision;
    String version;

    @Given("the client uses the \\/api\\/{int}.{int}.{int} with precision {double}")
    public void the_client_uses_the_api(int a, int b, int c, double p) {
        total = 0d;
        version = format("/api/%d.%d.%d/", a, b, c);
        precision = p;
    }

    @When("the client adds {double} and {double}")
    public void the_client_adds_and(Double a, Double b) {
        total = callOpService(version, "add", a, b);
    }

    @When("the client subtracts {double} from {double}")
    public void the_client_subtracts_from(Double a, Double b) {
        total = callOpService(version, "sub", a, b);
    }

    @When("the client mutiplies {double} and {double}")
    public void the_client_mutiplies_and(Double a, Double b) {
        total = callOpService(version, "mul", a, b);
    }

    @When("the client divides {double} with {double}")
    public void the_client_divides_with(Double a, Double b) {
        total = callOpService(version, "div", a, b);
    }

    @Then("the result should be {double}")
    public void the_result_should_be(Double answer) {
        assertEquals(answer, total, precision);
    }
}