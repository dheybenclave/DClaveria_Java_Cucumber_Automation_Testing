Feature: Verify different GET operations using REST-assured 

@All @Performance
Scenario: Verify one author of the post 
	Given I perform GET operation for "/posts" 
	When I perform GET for the post number "2" 
	Then I should see the author name as "api"