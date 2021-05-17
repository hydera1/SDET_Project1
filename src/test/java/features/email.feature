@email
Feature: send email

  Background: Initializing browser

  Scenario Outline: Verification of sending mail
    Given Go to upskill url
    When enter "<username>" and "<password>"
    And click on login
    And click on compose link and type email
    Then click on send message
    And validate successful message

    Examples: 
      | username | password   |
      | 12test12 | test@1     |
