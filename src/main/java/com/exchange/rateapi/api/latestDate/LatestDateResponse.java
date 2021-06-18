package com.exchange.rateapi.api.latestDate;

import com.exchange.rateapi.common.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestDateResponse extends BaseResponse {

    private String success;
    private String base;
    private String date;
    private Rates rates;
    private String error;

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rates {
        private String GBP;
        private String HKD;
        private String IDR;
        private String ILS;
        private String DKK;
        private String INR;
        private String CHF;
        private String MXN;
        private String CZK;
        private String SGD;
        private String THB;
        private String HRK;
        private String MYR;
        private String NOK;
        private String CNY;
        private String BGN;
        private String PHP;
        private String SEK;
        private String PLN;
        private String ZAR;
        private String CAD;
        private String ISK;
        private String BRL;
        private String RON;
        private String NZD;
        private String TRY;
        private String JPY;
        private String RUB;
        private String KRW;
        private String USD;
        private String HUF;
        private String AUD;
        private String EUR;
        private String LVL;
    }
}
