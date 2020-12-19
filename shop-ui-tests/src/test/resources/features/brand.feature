Feature: Adding brand

  Scenario Outline: Successful Login to the page, adding brand and logout after
    Given I open web browser
    When I navigate to login page
    And I provide username as "<username>" and password as "<password>"
    And I click on login button
    Then name should be "<name>"
    Then I click on brand navigation link
    Then I click on create new btn
    Then I provide brand name as "<brand>"
    Then I click submit btn
    When Open dropdown menu
    And click logout button
    Then user logged out

    Examples:
      | username | password | name  | brand  |
      | admin    | admin    | admin | Reebok |
