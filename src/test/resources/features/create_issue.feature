    Feature: Create Issue

      Background:
       Given I navigate to Jira Login Page
       Then I enter username - "VyacheslavArtyomenko"
       And I enter password - "VyacheslavArtyomenko"
       And I click on the login button

      @Regression
      Scenario: Create Issue
        Given I am on the Home Page
        When I click on the create button
        Then i fill all manatory fields
        Then the issue number is shown