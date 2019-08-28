@tag
Feature: Tariff plan
  I want to use this template for my feature file

  @tag1
  Scenario: Tariff plan Details
    Given User should launch the Browser
    And User click the Add Tariff button
    When USer Should provide the Details
      | montrent | localmint | intermint | smspack | pmchrg | ipcharge | smscharge |
      |     5000 |      2500 |      3000 |     100 |    200 |      500 |        10 |
      |    10000 |      3500 |      4000 |     300 |    500 |      100 |        20 |
      |     5000 |      2500 |      6000 |     400 |    400 |      150 |        30 |
    Then User Should click the Submit Button
