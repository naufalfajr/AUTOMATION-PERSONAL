Feature: Buy a product

  Scenario: Success buy product
    Given I navigate to "Catalog" menu
    When I select the product "Sauce Lab Back Packs"
    And I select color "Blue"
    And I set quantity to 2
    And I add the product to cart
    And I go to cart
