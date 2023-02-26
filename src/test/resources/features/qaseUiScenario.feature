Feature: UI test for qase.io

  Scenario Outline: test min and max values in Project Code field
    Given user logged in
    When create project with name "<projectName>" and code "<projectCode>"
    Then Project with name "<projectName>" is displayed
    Examples:
      | projectName | projectCode |
      | testMin       | 1           |
      | testMax       | 1234567890  |

  Scenario: test min-1 value in Project Code field
    Given user logged in
    When create project with name "test" and code ""
    Then

   Scenario: test max+1 value in Project Code field
    Given user logged in
    When create project with name "test" and code "12345678901"
    Then


