Feature: Elearning Upskill website Register

  Scenario: Allows the user to get registered  by entering valid credentials in required fields
    Given  User should launch the application by entering valid URL
    And Click on Account icon
    And Click on Register button
    When Fill registration form and Submit details
    	| firstname | lastName | email             |  telephone  | address1      | address2 | City | postalcode | password | confirm password | 
      | manzoor   | mehadi   | manzor895@gmail.com |  9876543210 | yeshwanthapur | bangalore| India| Karnataka  | manzoor1 | manzoor1         |
    And Click on No radio button in Subscribe
    And Click on I have read and agree to the Privacy Policy checkbox
    Then Click on Continue button
    And Message should get displayed on next page with Continue button  

    
