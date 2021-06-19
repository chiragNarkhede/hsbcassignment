package com.exchange.rateapi.testData;

public enum TestData {

    ACCESS_KEY("3ce48236bc1f8785998044e3218dba90"),
    INCORRECT_KEY("3ce48236bc1f8785998044e3218dba91"),
    FUTURE_DATE("2022-10-02"),
    USER_DATE("2021-05-10");

    private String testData;
    TestData(String testData) {
        this.testData = testData;
    }
    public String getData() {
        return testData;
    }
}
