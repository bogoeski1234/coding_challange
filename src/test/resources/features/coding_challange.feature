@git
Feature: GitHub Navigation

  Background: I login in to GitHub
   # Given I login with username and password

  Scenario: Verify Number of Repository
    When I enter "hygieia" in the search Box field and hit Enter
    Then we match num Of Repo and num of search Results
    And we should see 3 or more in the "search Results"

    When we select "Hygieia/Hygieia" Repository from list Repositories
    Then we should see following value
      | commits      |
      | branches     |
      | releases     |
      | contributors |
    And we should see 2001 or more in the "commits"
    And we should see 4 or more in the "branches"
    And we should see 8 or more in the "releases"
    And we should see 51 or more in the "contributors"