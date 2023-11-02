Feature: Feature to test Hompage 

Scenario: User launch home page of an dsalgo project
  Given the user opens DS Algo portal link
  #  When the user clicks the Get Started button ****without passing string from here
  When the user clicks the "Get Started" button
  Then the user should be redirected to homepage 

 Scenario Outline: User is on Homepage and click GetStarted link on Homepage without sign in
    Given the User is on HomePage
    When the user clicks on Get Started link on homepage "<options>"  without login
    Then the user get warning message "You are not logged in"
    
    Examples:
    |options|
    |Datastructures|
    |Arrays|
    |Linked List|
    |Stack|
    |Queue|
    |Tree|
    |Graph|
    Scenario Outline: User is on Homepage and click Dropdown on Homepage without sign in
    Given the User is on HomePage
    When the user clicks on Dropdown on homepage "<options>" without login
    Then the user get warning message "You are not logged in"
    Examples:
    |options|  
    |Arrays|
    |Linked List|
    |Stack|
    |Queue|
    |Tree|
    |Graph|
    
    Scenario: User is going into RegisterPage
    Given the User is on HomePage
    When the user clicks on RegisterLink
    Then the user landsOn Register Page
    
   
    Scenario: User is going into SigninPage
    Given the User is on HomePage 
    When the user clicks on Sign in link after getting the not logged in message
    Then the user lands on loginPage
    
    Scenario Outline: User logging into Homepage after signing in successfully
    Given the user is on SignInPage
    When the user gives valid username password from sheetname "<sheetname>" and RowNumber <RowNumber> and clicks Login button
    Then the user lands onto HomePage and displays the message "You are logged in"
    Examples: 
      | sheetname    | RowNumber |
      | Logindetails |         1 |
      
   
    Scenario: User is on Homepage and able to naviagate to Datastructure page
    Given user is on Homepage after logged in
    When the user clicks on DataStructure Get started button 
    Then the user should be navigated to DataStructure Page having title "Data Structures-Introduction"
 
 	    Scenario: User is able to signout
    Given user is on Homepage after logged in
   When the user clicks on signout link
   Then the user SignsOut and displays the message "Logged out successfully"
 # Scenario: HomePage title
#    Given the user is on HomePage
#    When the user lands on HomePage
#    Then the user gets the Url of the HomePage
     
#    Scenario: User is on HomePage able to navigate to Register Page
#    Given the user is on Home Page after logged in
#    When The user clicks "Register" link
#    Then the user should be redirected to Register form
#    Scenario: User is on Homepage and able to naviagate to Array page
#    Given user is on Homepage after logged in
#    When the user clicks on Array Get started button or from dropdown
#    Then the user should be navigated to Array Page

#    Scenario: User is on HomePage and able to naviagate to Graph page
#    Given user is on Homepage after logged in
#    When the user clicks on Graph Get started button or from dropdown
#    Then the user should be navigated to Graph Page
#    Scenario: User is on Homepage and able to naviagate to Stack page
#    Given user is on Homepage after logged in
#    When the user clicks on Stack Get started button or from dropdown
#    Then the user should be navigated to Stack Page
#    Scenario: User is on Homepage and able to naviagate to Queue page
#    Given user is on Homepage after logged in
#    When the user clicks on Queue Get started button or from dropdown
#    Then the user should be navigated to Queue Page
#    Scenario: User is on Homepage and able to naviagate to LinkedList page
#    Given user is on Homepage after logged in
#    When the user clicks on LinkedList Get started button or from dropdown
#    Then the user should be navigated to LinkedList Page
#    Scenario: User is on Homepage and able to naviagate to Tree page
#    Given user is on Homepage after logged in
#    When the user clicks on Tree Get started button or from dropdown
#    Then the user should be navigated to Tree Page
    
    
   