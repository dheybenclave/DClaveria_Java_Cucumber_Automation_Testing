Feature: Test Invalid User Credentials Feature 

@All  @testInvalid
Scenario Outline: Login fail possible combinations 
	Given that the user should navigate in PEGA Login Page
    And user verify the Login Page Elements is Visible
    When user login using invalid credentials with username "invalidUser" and password "InvalidPassword"
    When user login using invalid credentials form ExcelData with File "<ExcelFile>" and SheetName "<SheetName>"
    Then user should not proceed to Dashboard Page
#	But user login 
	Then user gets login failed error message 
	
	Examples: 
#		Note: The FilePath of the Excel should be in ./src/main/resources/TestData/
		| ExcelFile		  		 | SheetName	          |
		| InvalidUserCredentials | InvalidUserCredentials |
