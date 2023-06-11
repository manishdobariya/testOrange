
Feature: Login

  Scenario Outline: User login with valid credentials
    Given User is on login page
    When User Enter userName "<FullName>"
    And User Enter pass "<password>"
    And User click on Login button
    Then user should see a validation message "<message>"
    Examples:
      |FullName  |password| message |
      |manish patel     | 12345 | Hello manish patel, let's complete the test form:|


  Scenario Outline: User login with invalid credentials
    Given User is on login page
    When User Enter userName "<FullName>"
    And User Enter pass "<password>"
    And User click on Login button
    Then user should see an invalidation message "<message>"
    Examples:
    | FullName | password  | message|
    | user1    | 247 | Password is invalid |
    | user2    | 752 | Password is invalid |
    | user3    |     | Password is invalid |
    |          |     |  Password is invalid|

  Scenario Outline: User login with Blank Username
    Given User is on login page
    When User Enter userName "<FullName>"
    And User Enter pass "<password>"
    And User click on Login button
    Then user should see an error message "<message>"
    Examples:
      | FullName | password  | message|
    |            |12345    |Please provide your full name|

