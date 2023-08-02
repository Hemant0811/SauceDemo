Feature: validate logout functionality

@Reg
Scenario: Verify sucessful logout

Given user enter "standard_user" and "secret_sauce"
And user click on login button
And user click on three dot option
And user click on logout button 
And verify logout sucessfully