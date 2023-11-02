Feature: Feature to test Graph Page
Scenario: The user is able to navigate to GRAPH Data Structure Page
    Given The user is on the home page after logged in
    When The user selects Graph item from the drop down menu
    Then The user should be redirected to Graph Data Structure Page having page title "Graph"
 
    Scenario: The user is able to navigate to Graph page
    Given The user is on the Graph Page after logged in
    When The user clicks Graph link on Graph page
    Then The user should be redirected to Graph page in Graph page having page title "Graph"
    
    Scenario: The user is able to navigate to a page having an tryEditor from Graph page
    Given The user navigates to Graph page from Graph page
    When the user clicks on TryHere button
    Then the user should be redirected to Try Editor Page having page Title "Assessment"
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
      Scenario: The user is able to navigate to Graph Representations link
    Given The user is on the Graph Page after logged in
    When The user clicks on Graph Representations link
    Then The user should be redirected to Graph Representations page having page title "Graph Representations"   
    Scenario: The user is able to navigate to a page having an tryEditor from Graph Representations page
    Given The user navigates to Graph Representations page
    When the user clicks on TryHere button
    Then the user should be redirected to Try Editor Page having page Title "Assessment"
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
      