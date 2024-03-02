Feature: Calculator functionality
  As a user,
  I want to perform basic arithmetic operations,
  So that I can quickly calculate mathematical expressions.

  Scenario: Addition
    Given I enter 5
    And I press add
    And I enter 7
    When I press equals
    Then the result should be 12 on the screen

  Scenario: Subtraction
    Given I enter 10
    And I press subtract
    And I enter 4
    When I press equals
    Then the result should be 6 on the screen

  Scenario Outline: Multiplication with multiple inputs
    Given I enter <num1>
    And I press multiply
    And I enter <num2>
    When I press equals
    Then the result should be <result> on the screen

    Examples:
      | num1 | num2 | result |
      | 2    | 3    | 6      |
      | 4    | 5    | 20     |
      | 10   | 0    | 0      |

  Scenario: Division
    Given I enter 15
    And I press divide
    And I enter 3
    When I press equals
    Then the result should be 5 on the screen

  Scenario Outline: Division with various inputs
    Given I enter <numerator>
    And I press divide
    And I enter <denominator>
    When I press equals
    Then the result should be <quotient> on the screen

    Examples:
      | numerator | denominator | quotient |
      | 10        | 2           | 5        |
      | 20        | 4           | 5        |
      | 15        | 5           | 3        |
