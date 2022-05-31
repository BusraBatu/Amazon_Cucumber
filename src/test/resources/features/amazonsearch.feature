@searching
Feature: US0002 Amazon Search

  Background: User enter the account successfully
    Given User navigate to the amazon homepage

  Scenario: TC004 Book Searching
    Given User select books and search Momo
    When Select first product
    And Verify author is "Michael Ende"

  Scenario: TC005 Headphones Searching
    Given User search headphones
    Then User select brand is "Sony"
    And Verify products contain a product name "SONY WH-CH710N"
    #Above step is used to test is failed for report results


    Scenario: TC006 Bicycle Searching
      Given User search bicycle
      Then User select price $"100" to $"200"
      And User click third line product from the results
      And Verify product is bicycle and price is in the range "100" to "200"