package com.exchange.rateapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpecificDateResponse extends BaseResponse {
    private String success;
    private String historical;
    private String date;
    private RateResponse rates;
    private Errors error;


    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Errors{
        private String code;
        private String message;
    }
}
