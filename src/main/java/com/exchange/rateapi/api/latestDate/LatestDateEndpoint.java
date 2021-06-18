package com.exchange.rateapi.api.latestDate;

import com.exchange.rateapi.utils.CommonUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class LatestDateEndpoint {

    public LatestDateResponse getLatestDateResponse() {
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("access_key", "3ce48236bc1f8785998044e3218dba90")
                .get(CommonUtils.getLatestExchageRateURL());
        LatestDateResponse latestDateResponse = response.as(LatestDateResponse.class);
        latestDateResponse.setHttpStatusCode(response.getStatusCode());
        return latestDateResponse;
    }
}
