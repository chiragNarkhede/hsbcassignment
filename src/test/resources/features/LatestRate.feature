
Feature: Rates API for Latest Foreign Exchange rates

  Background:
    Given the rate API is available
  @smoke @regression
  Scenario: Verify rates API response status
    Then the response status code should be 200

  @regression
  Scenario: Verify rates API success status
    Then success status should be true

  @regression
  Scenario: Verify rate API response Details
    Then the exchange rate for INR should matches

  @smoke @regression
  Scenario: Verify response for incorrect API
    And user entered incorrect API
    Then user should received error message


