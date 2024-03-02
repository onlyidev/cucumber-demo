Feature: Product Inventory
  As a store manager
  I want to manage the inventory of products
  So that I can keep track of available stock

  Scenario: Adding products to inventory
    Given I am on the product inventory page
    When I add the following products:
      | Name        | Quantity | Price |
      | Laptop      | 10       | $1000 |
      | Smartphone  | 20       | $500  |
    Then the products should be added to the inventory