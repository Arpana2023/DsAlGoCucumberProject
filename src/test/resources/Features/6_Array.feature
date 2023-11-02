Feature: Feature to test Array page

  Scenario: The user is able to navigate to ARRAY Data Structure Page
    Given The user is on the home page after logged in
    When The user select Array item from the drop down menu
    Then The user should be redirected to Array Data Structure Page having page title "Array"

  Scenario: The user is able to navigate to Arrays in Python page
    Given The user is on the Array page after logged in
    When The user clicks Arrays in Python link
    Then The user should be redirected to Arrays in Python page having page title "Arrays in Python"   

  Scenario: The user is able to navigate to a page having an tryEditor from Arrays in Python page
    Given The user is on the Arrays in Python page after logged in
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
     
       Scenario: The user is able to navigate to Arrays Using List page
    Given The user is on the Array page after logged in
    When The user clicks Arrays Using List link
    Then The user should be redirected to Arrays Using List page having page title "Arrays Using List"   
    
     Scenario: The user is able to navigate to a page having an tryEditor for Arrays Using List page
    Given The user is on the Arrays Using List after logged in
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
     
   Scenario: The user is able to navigate to Basic Operations in Lists page
    Given The user is on the Array page after logged in
    When The user clicks Basic Operations in Lists link
    Then The user should be redirected to Basic Operations in Lists page having page title "Basic Operations in Lists"
    
    Scenario: The user is able to navigate to a page having an tryEditor f Basic Operations in Lists page
    Given The user is on the Basic Operations in Lists after logged in
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
      
      Scenario: The user is able to navigate to Applications of Array page
    Given The user is on the Array page after logged in
    When The user clicks Applications of Array link
    Then The user should be redirected to Applications of Array page having page title "Applications of Array"
    
    Scenario: The user is able to navigate to Practice page
    Given The user is on the Arrays in Python page after logged in
    When The user clicks Practice Questions link
    Then The user should be redirected to Practice page having title "Practice Questions"
     
     Scenario: The user is able to navigate to Question page from Search the array link
    Given The user is on the Practice page after logged in
    When The user clicks the Search the array link
    Then The user should be redirected to question page having tryEditor with Run and Submit buttons having page Title "Assessment"
     
     Scenario Outline: The user is able to run code in tryEditor for Search the array link
    Given The user is on "Question" page of "Search the array" after logged in
    When The user enter valid python code in tryEditor from sheetname "<Sheetname>" and rownumber <RowNumber> and clicks Run button
    Then The user should be presented with Run result

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         2 | 