Feature: Verify DELETE operations using REST-assured 


@All @Performance @DeleteTesting 
Scenario: Validate and Verify DELETE for userCredentials
	Given I perform DELETE operation for "/userCredentials" 
    When user perform a post operation with body for delete operation
    	| username	    | password      | titlePage 	        |
    	| usertoDelete  | passtoDelete  | Cosmos Application    |
    	
    And I will see the created data with username "usertoDelete"
    Then I will delete the posted data for "/userCredentials/{id}/" 
    And Verify that the created data is no longer available	