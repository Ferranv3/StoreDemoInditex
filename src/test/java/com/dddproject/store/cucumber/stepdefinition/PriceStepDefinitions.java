package com.dddproject.store.cucumber.stepdefinition;

import com.dddproject.store.application.service.PriceQueryServiceImpl;
import com.dddproject.store.cucumber.CucumberSpringConfiguration;
import com.dddproject.store.domain.model.Price;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PriceStepDefinitions extends CucumberSpringConfiguration {

    @Autowired
    private PriceQueryServiceImpl priceQueryService;

    private Price resultPrice;
    private LocalDateTime queryDate;
    private Long productId;
    private Long brandId;

    @Given("I have a product with ID {string}")
    public void i_have_a_product_with_id(String productId) {
        this.productId = Long.parseLong(productId);
    }

    @Given("I have a brand with ID {string}")
    public void i_have_a_brand_with_id(String brandId) {
        this.brandId = Long.parseLong(brandId);
    }

    @When("I search for prices for the product on {string}")
    public void i_search_for_prices_for_the_product_on(String date) {
        queryDate = LocalDateTime.parse(date);
        resultPrice = priceQueryService.findApplicablePrice(queryDate, productId, brandId);
    }

    @Then("I should receive a price")
    public void i_should_receive_a_price() {
        assertNotNull(resultPrice);
    }
}