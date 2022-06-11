Feature: Elearning Upskill website 
 
 
Scenario: Allows user to get logged in by entering valid credentials in required field
  Given User should launch the application by entering URL
   And Click on Account
   When Enter valid Credentails in textboxes
    		|Email               |Password |
    		|manzor895@gmail.com | manzoor1|
   And Click on Login 
   Then My Account Page is displayed.