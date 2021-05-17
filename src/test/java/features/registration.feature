@Registration
Feature: Register new user in upskill portal

  Background: Initializing browser

  Scenario Outline: verify successful registration
    Given User navigates to home page
    And click on signup button
    When fill all the fields "<firstname>","<lastname>","<email>","<username>","<password>","<confirm password>"
    And Click on Register
    Then validate the success message after register

    Examples: 
      | firstname | lastname | email          | username | password   | confirm password |
      | test1     | test1    | test@test.test | 13test13 | test@1     | test@1           |
