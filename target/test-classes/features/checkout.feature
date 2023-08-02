Feature: Validate checkout functionality 

@Reg 
Scenario: validate checkout with valid details 

	Given user enter "standard_user" and "secret_sauce" 
	And user click on login button 
	And user add product into the basket from PLP page 
	And user navigate to cart page 
	And user enter information "himanshu" "mehra" "263142" 
	And user place order with cash on delivery 
	And validate order confirmation 
	
@Reg 
Scenario: validate checkout with blank details 
	 
	Given user enter "standard_user" and "secret_sauce" 
	And user click on login button 
	And user add product into the basket from PLP page 
	And user navigate to cart page 
	And user enter information "" "" "" 
	And validate error message 
	
@Reg 
Scenario: validate checkout with blank details  

	Given user enter "standard_user" and "secret_sauce" 
	And user click on login button 
	And user add product into the basket from PLP page 
	And verify product name and price 
	
