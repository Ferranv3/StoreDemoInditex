package com.dddproject.store.cucumber;

import com.dddproject.store.StoreApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = StoreApplication.class)
public class CucumberSpringConfiguration {
}