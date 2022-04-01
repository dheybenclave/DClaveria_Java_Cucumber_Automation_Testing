Feature: Verify different POST operations using REST-assured 


@All @Performance @POSTTesting @testing4
Scenario: Validate and Verif PATCH for comments
	Given I perform PATCH operation for "/comments" 
    When user perform a PATCH operation with body for "Comments"
    	| id	| body     				 | postId 	 |
    	| 4     | this is updated value  | 4		 |
    	
    Then I will see the created patch data with body "this is updated value "