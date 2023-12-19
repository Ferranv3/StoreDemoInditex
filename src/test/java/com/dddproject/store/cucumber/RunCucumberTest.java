package com.dddproject.store.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.dddproject.store.cucumber",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RunCucumberTest {
}