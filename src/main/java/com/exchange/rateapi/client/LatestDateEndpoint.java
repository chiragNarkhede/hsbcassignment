package com.exchange.rateapi.client;

import com.exchange.rateapi.entity.LatestDateResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class LatestDateEndpoint {

    // Get Latest date Response
    public LatestDateResponse getLatestDateResponse(String URL , String accessKey) {
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("access_key", accessKey)
                .get(URL);
        LatestDateResponse latestDateResponse = response.as(LatestDateResponse.class);
        latestDateResponse.setHttpStatusCode(response.getStatusCode());
        return latestDateResponse;
    }

    // Get Latest date Response with Country code
    public LatestDateResponse getResponseAsPerSymbol(String url ,String symbol,String accessKey) {
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("access_key", accessKey)
                .queryParam("symbols",symbol)
                .get(url);

        LatestDateResponse latestDateResponse = response.as(LatestDateResponse.class);
        latestDateResponse.setHttpStatusCode(response.getStatusCode());
        return latestDateResponse;
    }

}
