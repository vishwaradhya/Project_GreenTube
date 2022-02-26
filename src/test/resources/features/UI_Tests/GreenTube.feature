@GreenTubeUI
Feature: This feature is to verify the Login-Search-Add-Remove-checkout funtionality 
  


	
@login     
Scenario: Verify user can login sucessfully into ecommerce portal  
    Given User launch "http://automationpractice.com/index.php"
    And user clicks on Sign In Button to navigate sign in or login page
    When user logs into automationpractice with valid credentials
    Then user verifies the sucessful login
    And user logs out form the application


@addAndRemoveCart    
Scenario: Verify user should be able to add items to cart and remove as well 
    Given User launch "http://automationpractice.com/index.php"
    And user clicks on Sign In Button to navigate sign in or login page
    And user logs into automationpractice with valid credentials
    Then user verifies the sucessful login
    And Search item "Casual Dresses" using search icon
    And Select first item and add to cart
    #verify add operation
    And Search item "Evening Dresses" using search icon
		And Select first item and add to cart
		#verify add operation - layer_cart
    And Search item "t-shirt" using search icon
 	  And Select first item and add to cart
    When user remove one product from the cart
    Then verify that product is removed from the cart
    And user logs out form the application
    
    
    
    
        
@checkout     
Scenario: Verify user should be able to perform checkout operation 
    Given User launch "http://automationpractice.com/index.php"
    And user clicks on Sign In Button to navigate sign in or login page
    And user logs into automationpractice with valid credentials
    And Search item "Casual Dresses" using search icon
    When Select first item and add to cart and proceed to checkout
   	And user select Proceed to checkout option and agree the condition
   	Then user verifies the final page "Please choose your payment method" for checkout operation
    And user logs out form the application
    


    @addAndRemoveCart2     
Scenario: Verify Login-Search-Add-Remove 
    Given User launch "http://automationpractice.com/index.php"
    And user clicks on Sign In Button to navigate sign in or login page
    And user logs into automationpractice with valid credentials
    Then user verifies the sucessful login
    And Search item "Casual Dresses" using search icon
    And Select first item and add to cart
    And Search item "Evening Dresses" using search icon
		And Select first item and add to cart
    And Search item "t-shirt" using search icon
 	  And Select first item and add to cart
    When user remove one product from the cart
    Then verify that product is removed from the cart
    And user logs out form the application