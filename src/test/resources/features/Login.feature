Feature: Login feature

  Scenario: Login Success
    #Given I open Login Page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I click on login button
    Then I should be logged in

  Scenario Outline: Login Success
    When I enter email "<email>"
    And I enter password "<password>"
    And I click on login button
    Then I should be logged in

    Examples:
      | email           | password    |
      | demo@class.com  | te$t$tudent |
      | demod@class.com | test$tudent |
      |                 |             |
      | demod@class.com |             |
