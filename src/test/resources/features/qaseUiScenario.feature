@ui
Feature: UI tests for qase.io

  @minMaxUiTest
  Scenario Outline: test min and max values in Project Code field
    Given user logged in
    When user creates project with name "<projectName>" and code "<projectCode>"
    Then Project page is opened
    * '"<projectCode>" repository' is displayed

    Examples:
      | projectName | projectCode |
      | 1           | 12          |
      | 2           | 1234567890  |

  Scenario Outline: test min-1 and max+1 values in Project Code field
    Given user logged in
    When user creates project with name "<projectName>" and code "<projectCode>"
    Then 'Create new project' dialog is still opened
    * message "<message>" is displayed

    Examples:
      | projectName | projectCode | message                                         |
      | 3           | 1           | The code must be at least 2 characters.         |
      | 4           | 12345678901 | The code may not be greater than 10 characters. |

  Scenario Outline: checking popup title in Suite entity
    Given user logged in
    When user navigates to ProjectPage
    Then suite with "<title>" is presented

    Examples:
      | title                 |
      | SuiteFromPostResponse |
