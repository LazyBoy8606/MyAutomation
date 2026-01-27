@OrderPlacing
  Feature: Testing order placing functionality
    @Selection
    Scenario Outline: Select App for order placing
      Given User login to "<Application>"
      When User Search "<Product>" in "<Application>"
      Examples:
        |  Application|Product  |
        |  FlipKart   |  S23    |
        |  Amazon     |  s24    |