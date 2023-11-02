Feature: Feature to test RegisterPage
Scenario: RegisterPage Title
    Given the user is on RegistrationPage
    When the user gets the Title of the RegisterPage
    Then the page title to be "Registration"
    
#    Scenario: Clicking on Register button in Registration Page
#    Given the user is on RegistrationPage
#    When the user clicks on Register button
#    Then the user lands on to LoginPage
#    
    Scenario: The user is presented with error message for empty fields below Username textbox
    Given the user is on RegistrationPage
    When The user clicks Register button with all fields empty
    Then It should display an error "Please fill out this field." below Username textbox
    
    Scenario Outline: The user is presented with error message for empty fields below Password textbox
    Given the user is on RegistrationPage
    When The user clicks Register button after entering username "username" with all fields empty
    Then It should display an error "Please fill out this field." below Password textbox
    Examples:
    | username       |
    | Numpy@sdet84_1 |
    Scenario Outline: The user is presented with error message for empty fields below Password Confirmation textbox
    Given the user is on RegistrationPage
    When The user clicks Register button after entering username "username" and password "password" with all fields empty
    Then It should display an error "Please fill out this field." below Password Confirmation textbox
    Examples:
    | username         | password     |
    | Numpy@sdet84_1   | testpassword |
    
    Scenario Outline: The user is presented with error message for password mismatch
    Given the user is on RegistrationPage
    When The user clicks Register button after entering valid username and sheetname "<sheetname>" and rownumber <rownumber> different passwords in password and password confirmation fields from excelsheet
    Then It should display an error message for passwordMismatch
    Examples:  
    |sheetname          |rownumber|
    |RegisterPageDetails|0        |

#    Scenario Outline: The user is presented with error message for password with characters less than 8
#    Given the user is on RegistrationPage
#    When The user enters a valid username and password with characters less than eight from sheetname "<sheetname>" and rownumber <rownumber>
#      Then It should display an error message for password lessthan 8characters
#     Examples:  
#    |sheetname           |rownumber|
#    |RegisterPageDetails |1        |
#    Scenario Outline:The user is presented with error message for password having only numbers
#    Given the user is on RegistrationPage
#    When the user enters valid username and password having only numbers from sheetname "<sheetname>" and rownumber <rownumber>
#    Then it should display an error msg password cannot be numeric
#    Examples:  
#    |sheetname           |rownumber|
#    |RegisterPageDetails |2        |