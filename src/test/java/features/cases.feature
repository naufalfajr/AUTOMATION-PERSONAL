Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given the app is launched
    When I enter username "testuser"
    And I enter password "password123"
    And I tap on login button
    Then I should see the home screen
