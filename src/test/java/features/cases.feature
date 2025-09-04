Feature: Buy a product

  Scenario: Success buy product
    Given I navigate to "Catalog" menu
    When I select the product "Sauce Lab Back Packs"
    And I select color "Blue"
    And I set quantity to 2
    And I add the product to cart
    And I go to cart
    Then Verify product "Sauce Lab Back Packs" with quantity 2 is added to cart
    And Verify product color is displayed
    And Verify total price is correct on the cart
    And I proceed to checkout
    When I enter login credentials
    And I click login button
    And I enter "John Doe" to field "Full Name" on shipping address form
    And I enter "Jl. Semangka" to field "Address Line 1" on shipping address form
    And I enter "Jakarta Selatan" to field "City" on shipping address form
    And I enter "Jakarta" to field "State" on shipping address form
    And I enter "98765" to field "Zip Code" on shipping address form
    And I enter "Indonesia" to field "Country" on shipping address form
    And I click to Payment button
    And I enter "John Doe" to field "Full Name" on payment form
    And I enter "4000000000001000" to field "Card Number" on payment form
    And I enter "0330" to field "Expiration Date" on payment form
    And I enter "123" to field "Security Code" on payment form
    And I click Review Order button
    Then Verify product image, name and price on review order page
    And Verify Shipping Address
    And Verify final price
    And Verify Payment Data
    And I place the order
    And Verify Order Complete page message is "Checkout Complete"
    And I click continue shopping button
