package com.vgernsoft.calc.op;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" }, features = "classpath:features", glue = "com.vgernsoft.calc.op")
public class CucumberIntegrationTest {

}
