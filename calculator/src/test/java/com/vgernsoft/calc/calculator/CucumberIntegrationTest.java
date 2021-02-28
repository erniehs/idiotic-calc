package com.vgernsoft.calc.calculator;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" }, features = "classpath:features", glue = "com.vgernsoft.calc.calculator")
public class CucumberIntegrationTest {

}
