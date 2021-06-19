package stepsDefinations;

import com.exchange.rateapi.api.specificDate.SpecificDateEndpoint;
import com.exchange.rateapi.api.specificDate.SpecificDateResponse;
import com.exchange.rateapi.constants.StatusCode;
import com.exchange.rateapi.testData.TestData;
import com.exchange.rateapi.utils.CommonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class SpecificDateRateSteps {

    SpecificDateEndpoint specificDateEndpoint;
    SpecificDateResponse specificDateResponse;
    String accessKey = TestData.ACCESS_KEY.getData(),
            url = CommonUtils.getGlobalValue("SPECIFIC_DATE_EXCHANGE_RATE");

    @Given("the rate API for specific date is available")
    public void theRateAPIIsAvailable() {
        specificDateEndpoint = new SpecificDateEndpoint();
        specificDateResponse = specificDateEndpoint.getSpecificDateResponse(url ,TestData.USER_DATE.getData(), accessKey);
    }

    @Then("the response status code for date should be {int}")
    public void theResponseStatusCodeForDateShouldBe(int statusCode) {
        Assert.assertEquals(specificDateResponse.getHttpStatusCode(),statusCode,
                "Status code is different.");
    }

    @Then("^historical status should be (\\w+)$")
    public void historicalStatusShouldBeTrue(String successStatus) {
        Assert.assertEquals(specificDateResponse.getHistorical(),
                successStatus,"Historical value is false");
    }

    @When("future date is provided to the foreign exchange rates service")
    public void futureDateIsProvidedToTheForeignExchangeRatesService() {
        specificDateResponse = specificDateEndpoint.getSpecificDateResponse(url ,TestData.FUTURE_DATE.getData(), accessKey);
    }

    @Then("the exchange rates api response should have the data based on current date")
    public void theExchangeRatesApiResponseShouldHaveTheDataBasedOnCurrentDate() {
        Assert.assertEquals(specificDateResponse.getHttpStatusCode(), StatusCode.SUCCESS_CODE,
                "API response was not successful");
        Assert.assertEquals(specificDateResponse.getDate(),TestData.FUTURE_DATE.getData(),
                "Specific date is not retrieved.");
    }
}
