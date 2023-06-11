
Feature: Registration


  Scenario: Successful registration
    Given : I am on registration page
    When : I enter valid First Name
    And : I enter valid Last Name
    And : I enter valid Email
    And : I enter valid Password
    And : I enter valid Confirm password
    And : I click REGISTER button
    Then : I should register successfully