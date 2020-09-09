Feature: Login To Jira

  @Regression @wip
  Scenario Outline: Login to Jira
    Given I navigate to Jira Login Page
    And I enter username - "<username>"
    And I enter password - "<password>"
    And I click on the login button
    Then I am on the Home Page

    Examples:
        | username | password |
        | VyacheslavArtyomenko | VyacheslavArtyomenko |
        | VyacheslavArtyomenko | wrongPassword |