Feature: Validate And Verify Login Page to PEGA Site 

# Regular Exporeession
#([0-9]) ->capture group-->0 to 9 digits appear
#l[0-9]+)-> 0 to 9 digits appear (once or more)
#([0-91{4}) --> 0000, 9999, 1212, 3456, 1234, 8888
#|([0-9]*) -> zero or more
#([0-9]?) -> zero or once
#\d-= numeric digits
#(\d+)

Background:
	Given that the user should navigate in PEGA Login Page
    And user verify the Login Page Elements is Visible
    When user login using invalid credentials with username "invalidUser" and password "InvalidPassword"
    Then user should not proceed to Dashboard Page

@All @Smoke @Test1
Scenario: Login to PEGA Site using Author, Manager and User
    When user login using valid credentials
    	| username	    | password | titlePage 			|
    	| author@vrbank | pega123! | Pega Dev Studio 	|
#    	| manager@vrbank| pega123! | Cosmos Application | 
#    	| user@vrbank   | pega123! | Cosmos Application |
    	
    Then user should proceed to Dashboard Page
    

@All
@Regression    
Scenario: Login to PEGA Site using User
    When user login using valid credentials with username "user@vrbank" and password "pega123!"
    Then user should proceed to Dashboard Page
