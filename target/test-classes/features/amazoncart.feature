Feature: US0003 Amazon Cart

  Background: User is on the amazon homepage
    Given User navigate to the amazon homepage


  @addcart
  Scenario: TC007 Compare the prices
    Given User search desk
    When User click eighteenth product
    Then Add to cart to product
    And Verify the page price and cart price is same