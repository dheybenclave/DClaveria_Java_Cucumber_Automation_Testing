Feature: Verify different POST operations using REST-assured 


@All @Performance @PatchTesting
Scenario: Validate and Verify PATCH for comments
	Given I perform PATCH operation for "/comments" 
    When user perform a PATCH operation with body
    	| id | body | postId |
    	| 3  | this is updated value | 3 |
    	
    Then I will see the created patch data with body "this is updated value"