package com.testing.secondlab.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/java/resources"},
        glue = {"com.testing.secondlab.cucumber"}
)
public class CucumberTestRunner {
}
