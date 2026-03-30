Feature: Test iPhone prices with DB

  Scenario: Check iPhone prices with DB
    Given I get 3 first iPhone models and prices from Allo
    When I check these phones in DB
    Then Prices should match or be saved