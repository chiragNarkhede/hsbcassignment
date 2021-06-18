package com.exchange.rateapi.api.specificDate;

import com.exchange.rateapi.api.latestDate.LatestDateResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SpecificDateEndpoint {

    public LatestDateResponse getSpecificDateResponse(String URL) {
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("access_key", "3ce48236bc1f8785998044e3218dba90")
                .get(URL);
        LatestDateResponse latestDateResponse = response.as(LatestDateResponse.class);
        latestDateResponse.setHttpStatusCode(response.getStatusCode());
        return latestDateResponse;
    }

}
