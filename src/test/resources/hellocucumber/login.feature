Feature: Login
  Scenario: Register a user scenario
    The user registration should work
  Given the demo page
    Then generate a random user
    And log in
    Then user is logged in

  Scenario: Something
    Given the demo page