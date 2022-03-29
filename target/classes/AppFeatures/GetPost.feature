Feature: Verify different GET operations using REST-assured 

@All @Performance @testing1
Scenario: Verify one author of the post 
	Given I perform GET operation for "/posts" 
	When I perform GET for the post number "2" 
	Then I should see the author name as "api"
	
@All @Performance @testing2
Scenario: Verify one existing user credentials
	Given I perform GET operation for "/usercredentials" 
	When I perform GET for the id number 2 
	Then I should see the username is "manager@vrbank" and password is "pega123!"
	
@All @Performance @testing3
Scenario: Verify one existing comments
	Given I perform GET operation for "/comments" 
	When I perform GET using parameter id number 3
	Then I should see the comment body is "this is comment for 3"