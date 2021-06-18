
Feature: Rates API for Latest Foreign Exchange rates

  Scenario: Verify rates API response status
    When the rate API is available
    Then the response status code should be 200


