@OrderPlacing
  Feature: Testing order placing functionality
    @Selection
    Scenario: Select App for order placing
      Given User login to "Amazon"
      When User Search "S23"
      And User Add to cart
      Then User validate order appeared in Cart