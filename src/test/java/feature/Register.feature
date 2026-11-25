Feature:user Registration validation demo 

	 		
 Scenario Outline:Verify successfull user registration 
	Given User navigate to the portal
	And User enters the username as "<username>"
	And User enters the password as "<password>"
	And User enters the confirmpassword as "<confirmpassword>"
	When User clik on the Registration button
	Then Registration should be successful
	
	Examples:
     | username |password   |confirmpassword|
	|Firsttesting123|12345abc|12345abc|
	|secondtesting134|cde5678|cde5678|
	|thirdtesting145|0987ase|0987ase|
	
	