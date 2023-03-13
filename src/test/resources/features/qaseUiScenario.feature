@ui
Feature: UI tests for qase.io

  Background:
    Given user logged in

  @minMaxUiTest
  Scenario Outline: test min and max values in Project Code field
    When user creates project with name "<projectName>" and code "<projectCode>"
    Then Project page is opened
    * '"<projectCode>" repository' is displayed

    Examples:
      | projectName | projectCode |
      | 1           | 12          |
      | 2           | 1234567890  |

  Scenario Outline: test min-1 and max+1 values in Project Code field
    When user creates project with name "<projectName>" and code "<projectCode>"
    Then 'Create new project' dialog is still opened
    * message "<message>" is displayed

    Examples:
      | projectName | projectCode | message                                         |
      | 3           | 1           | The code must be at least 2 characters.         |
      | 4           | 12345678901 | The code may not be greater than 10 characters. |

  Scenario: checking popup title in Suite entity
    When user navigates to ProjectPage
    Then suite with name "SuiteFromPostResponse" is presented

  Scenario: create case
    Given page of existed project is opened by url
    When user creates case
    Then message "Test case was created successfully!" is shown

  Scenario: delete suite entity
    Given user navigates to ProjectPage
    When user deletes suite entity
    Then message "Suite was successfully deleted." is presented

  Scenario: displaying the dialog window
    Given user navigates to ProjectPage
    When user cancels creation of test case
    Then dialog window with special elements is presented

  Scenario: adding attachment
    Given user navigates to ProjectPage
    When user starts creating case and adds attachment
    Then attachment is added

  Scenario Outline: checking the case name field
    Given user navigates to ProjectPage
    When user starts creating case and enters too long name
    Then "<message>" message appears
    * validation "<message>" is presented

    Examples:
      | message |
      | The title may not be greater than 255 characters. |