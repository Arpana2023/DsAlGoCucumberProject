Feature: Feature to test DataStructuresPage

Scenario: The user is able to navigate to Data Structure introduction page
Given The user is on the home page after logged in
When The user clicks the Getting Started button in Data Structure Page introduction Panel
Then The user should be redirected to data structure introduction page having title "Data Structures-Introduction"  
    
     Scenario: User is able to navigate to Time Complexity page
    Given  The user is on Data Structures introduction page
    When The user clicks the Time Complexity link
    Then The user should be redirected to the Time Complexity page having title "Time Complexity"
#    And the page title is to be "Time Complexity" 
    
    Scenario: The user is able to navigate to a page having an tryEditor from Time Complexity page
    Given the user is on TimeComplexityPage
    When the user clicks on TryHere button
    Then the user should be redirected to Try Editor Page having page Title "Assessment"
#    And the page Title has to be "Assessment" 
   
    Scenario Outline: The user is in a page having an tryEditor with a Run button to test invalid python syntax 
    Given the user is in a page having tryEditor 
    When The user enter python code with invalid syntax from sheet "<Sheetname>" and <RowNumber>
    Then  The user should be presented with error message "SyntaxError: bad input on line 1"
    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |
      
     Scenario Outline: The user is in a page having an tryEditor with a Run button to test valid python syntax    
      Given the user is in a page having tryEditor 
      When The user enter python code with valid syntax from sheet "<Sheetname>" and <RowNumber>  
     Then The user should be presented with Run result "Hello"
    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
    