Feature: Bag more functionalities

  Scenario: Putting one thing in the bag
    Given the bag is not empty
    When I empty the bag
    Then the bag is empty
