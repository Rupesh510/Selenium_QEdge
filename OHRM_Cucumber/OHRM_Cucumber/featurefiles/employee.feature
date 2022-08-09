@tag
Feature: New Employee Registration
  I want to use this template to check New Employee Registration

  @tag1
  Scenario: Check New Employee Registration with valid inputs
  
  Given i open browser with url "http://orangehrm.qedgetech.com"
	Then i should see login page
	When i enter username as "Admin"    
	And i enter password as "Qedge123!@#"
	And i click login
	Then i should see admin module
	When i click PIM
	And i click Add Employee
	Then i should see New Employee Registration Page
	When i enter firstname as "Naveen"
	And i enter lastname as "Demo"
	And i click Save
	Then i should see Employee Registered Successfully
	When i click logout
	Then i should see login page
	When i close browser
    