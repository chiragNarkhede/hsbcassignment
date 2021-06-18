package com.rate.api.tests.steps;

import com.exchange.rateapi.api.latestDate.LatestDateEndpoint;
import com.exchange.rateapi.api.latestDate.LatestDateResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LatestRateSteps {

    LatestDateEndpoint latestDateEndpoint;

    @When("the rate API is available")
    public void theRateAPIIsAvailable() {
        latestDateEndpoint = new LatestDateEndpoint();
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(latestDateEndpoint.getLatestDateResponse().getHttpStatusCode(),statusCode);
    }
}
