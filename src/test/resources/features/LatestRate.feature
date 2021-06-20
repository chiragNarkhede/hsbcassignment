
Feature: Rates API for Latest Foreign Exchange rates

  Background:
    Given the rate API is available
  @smoke @regression
  Scenario: Verify rates API response status and success status
    Then the response status code should be 200
    Then success status should be true

  @regression
  Scenario: Verify rate API response Details
    Then the exchange rate for INR should matches

  @smoke @regression
  Scenario: Verify response for incorrect API
    And user entered incorrect API
    Then user should received error message

  @regression
  Scenario: Verify rate API response for incorrect filter
    Then the exchange rate API should through error for incorrect symbol
    Then the exchange rate API should through error for empty symbol

