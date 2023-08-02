Feature: Validate Login functionality

@Reg
Scenario: Verify sucessful login with valid details 

Given user enter "standard_user" and "secret_sauce"
And user click on login button
Then validate user logged in succesfully




