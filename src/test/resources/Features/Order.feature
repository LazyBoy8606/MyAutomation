@OrderPlacing
  Feature: Testing order placing functionality
    @Selection
    Scenario Outline: Select App for order placing
      Given User login to "<Application>"
      When User Search "<Product>" in "<Application>"
      And User take a ScreenShot of "PorductsList"
#      And User validate Samsung Galaxy S23 in the Result
#      Then User val
    #
        #      idate FREE delivery as Fry, 30 Jan
#      And User validate date 12/12/2024 and time 12:34 PM
      Examples:
        |  Application|Product  |
        |  FlipKart   |  S23    |
        |  Amazon     |  S23    |
