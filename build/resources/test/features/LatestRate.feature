
Feature: Rates API for Latest Foreign Exchange rates

  Background:
    Given the rate API is available
  @Smoke
  Scenario: Verify rates API response status
#    When the rate API is available
    Then the response status code should be 200

  @Regression
  Scenario: Verify rates API success status
#    When the rate API is available
    Then success status should be true

  Scenario: Verify rate API response Details
#    When the rate API is available
    Then the exchange rate for INR should matches

  Scenario: Verify response for incorrect API
#    When the rate API is available
    And user entered incorrect API
    Then user should received error message


