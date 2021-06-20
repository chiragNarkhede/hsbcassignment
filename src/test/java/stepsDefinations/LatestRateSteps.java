package stepsDefinations;

import com.exchange.rateapi.client.LatestDateEndpoint;
import com.exchange.rateapi.entity.LatestDateResponse;
import com.exchange.rateapi.testData.TestData;
import com.exchange.rateapi.utils.CommonUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LatestRateSteps {

    LatestDateEndpoint latestDateEndpoint;
    LatestDateResponse latestDateResponse;
    LatestDateResponse latestDateResponseForIncorrectURL ;
    String correctAccessKey = TestData.ACCESS_KEY.getData(),
            incorrectKey = TestData.INCORRECT_KEY.getData(),
            url = CommonUtils.getGlobalValue("LATEST_FOREIGN_EXCHANGE_RATE");

    @Given("the rate API is available")
    public void theRateAPIIsAvailable() {
        latestDateEndpoint = new LatestDateEndpoint();
        latestDateResponse = latestDateEndpoint.getLatestDateResponse(url ,correctAccessKey);
        latestDateResponseForIncorrectURL = latestDateEndpoint.
                getLatestDateResponse(url,incorrectKey);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(latestDateResponse.getHttpStatusCode(),statusCode,
                "Status code is different.");
    }

    @Then("^success status should be (\\w+)$")
    public void successStatusShouldBeTrue(String successStatus) {
        Assert.assertEquals(latestDateResponse.getSuccess(),successStatus,
                "Success message is not correct.");
    }

    @Then("^the exchange rate for (\\w+) should matches$")
    public void theExchangeRateForINRShouldMatches(String inputSymbol) {
        Assert.assertEquals(latestDateEndpoint.getResponseAsPerSymbol(url,inputSymbol,correctAccessKey).getRates().getINR(),
                latestDateResponse.getRates().getINR(),
                "Exchange rate is not matched.");
    }

    @And("user entered incorrect API")
    public void userEnteredIncorrectAPI() {
        Assert.assertEquals(latestDateResponseForIncorrectURL.getError().getCode(),
                "invalid_access_key","Incorrect Error Message.");
    }

    @Then("user should received error message")
    public void userShouldReceivedErrorMessage() {
        Assert.assertEquals(latestDateResponseForIncorrectURL.getError().getMessage(),
                "You have not supplied a valid API Access Key. [Technical Support: support@apilayer.com]",
                "Incorrect Error Message.");
    }

    @Then("the exchange rate API should through error for incorrect symbol")
    public void theExchangeRateAPIShouldThroughError() {
        Assert.assertEquals(latestDateEndpoint.getResponseAsPerSymbol(url,"IN",correctAccessKey).getError().getCode(),
                "invalid_currency_codes",
                "Error code did not matched");
    }

    @Then("the exchange rate API should through error for empty symbol")
    public void theExchangeRateAPIShouldThroughErrorForEmptySymbol() {
        Assert.assertEquals(latestDateEndpoint.getResponseAsPerSymbol(url," ",correctAccessKey).getError().getCode(),
                "invalid_currency_codes",
                "Error code did not matched");
    }
}
