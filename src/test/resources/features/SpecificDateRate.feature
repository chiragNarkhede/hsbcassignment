
Feature: Rates API for Specific date Foreign Exchange rates

  Background:
    Given the rate API for specific date is available

  @Smoke
  Scenario: Verify rates API response status
    Then the response status code for date should be 200

  Scenario: Verify rates API success status
    Then historical status should be false

  @regression
  Scenario:
    When future date is provided to the foreign exchange rates service
    Then the exchange rates api response should have the data based on current date

