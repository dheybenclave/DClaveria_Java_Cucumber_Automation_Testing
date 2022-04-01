Feature: Verify different POST operations using REST-assured 


@All @Performance @POSTTesting
Scenario: Validate and Verif POST for comments
	Given I perform POST operation for "/userCredentials" 
    When user perform a post operation with body for "UserCredentials"
    	| username	    | password     | titlePage 	        |
    	| notValid      | invalidpass  | Cosmos Application |
    	| invalidUser3  | invalidpass3 | Cosmos Application |
    	| invalidUser2  | invalidpass2 | Cosmos Application |
    	
    Then I will see the created post data with username "invalidUser2"