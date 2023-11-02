Feature: Feature to test SignInPage
    Scenario: Verifying RegisterLink in SignInpage
    Given the user is on SignInPage
    When the user clicks on RegisterLink in SignInPage
    Then the user redirected to RegistrationPage
    Scenario Outline: User on login page and login with invalid inputs
    Given the user is on SignInPage
    When  The user have missing fields in username "<username>" and password "<password>"
    Then verify missing fileds message 
    Examples: 
      | username| password |
      |         | pass     |  
      | user    |          |
      |         |          |
#    Scenario Outline: User on login page and login with valid and invalid         from Excel
#    Given the user is on SignInPage
#    When  The user enters sheetname "<sheetname>" and RowNumber <RowNumber> from Excel sheet
#    Then the user verify valid login details
#    Examples: 
#      | sheetname    | RowNumber |
#      | Logindetails |         0 |
#      | Logindetails |         1 |
#      
      Scenario Outline: User on login page and login with valid from Excel
    Given the user is on SignInPage
    When  The user enters valid username password from sheetname "<sheetname>" and RowNumber <RowNumber> and clicks Login button 
    Then the user verify valid login details
    Examples: 
      | sheetname    | RowNumber |
      | Logindetails |         1 |