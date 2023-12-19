Feature: Find applicable prices

  Scenario: Finding a price for a specific product and date
    Given I have a product with ID "35455"
    And I have a brand with ID "1"
    When I search for prices for the product on "2020-06-14T10:00:00"
    Then I should receive a price