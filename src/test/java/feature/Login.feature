@smoke @login
Feature:user Login validation demo 

	 		
 Scenario Outline: Successful login with valid credentials from Excel 
	Given User navigate to the login portal
	When  User enters the username and password from excel <rowNumber>
	Then User should be successfully logged in
	
	Examples:
   |rowNumber|
   |4|