Feature: Feature to test GetStarted page 

Scenario: User launches Url
  Given User opens dsalgo application url
  When The user clicks the Get Started button
  Then The user should be redirected to homepage

# Scenario: User is on HomePage
#    Given User clicks on "GetStarted" button
#    Then user lands on HomePage
#    And gets the title of HomePage "NumpyNinja"