Feature: All Songs Feature

  Scenario: Play a Song
    Given I am logged in to Koel
    When I go to All Songs List
    When I context click first Song
    And Choose play option
    Then Song should be playing