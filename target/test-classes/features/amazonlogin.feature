@smoke
Feature: US0001 Amazon Login

  Background: User is on the amazon homepage
    Given User navigate to the amazon homepage
    When User click sign in button


  Scenario: TC001 Positive Amazon Login
    Then User enter valid email "miracle1112131415@gmail.com"
    And User enter valid password "111213"
    Then Verify successful login

  Scenario: TC002 Negative Amazon Login
    Then User enter invalid email "miracle11121314168@gmail.com"
    Then Verify unsuccessful login

  Scenario: TC003 Negative Amazon Login
    Then User enter valid email "miracle1112131415@gmail.com"
    And User enter invalid password "11121356"
    Then Verify unsuccessful login