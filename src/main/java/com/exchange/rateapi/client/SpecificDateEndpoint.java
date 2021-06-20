package com.exchange.rateapi.client;

import com.exchange.rateapi.entity.SpecificDateResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SpecificDateEndpoint {

    public SpecificDateResponse getSpecificDateResponse(String URL, String date, String accessKey) {
        String url = URL.concat(date);
        System.out.println(url);
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("access_key", accessKey)
                .get(url);
        SpecificDateResponse specificDateResponse = response.as(SpecificDateResponse.class);
        specificDateResponse.setHttpStatusCode(response.getStatusCode());
        return specificDateResponse;
    }
}
