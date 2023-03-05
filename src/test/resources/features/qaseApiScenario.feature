@api
Feature: Api tests for qase.io

  Scenario: NFE getting all projects
    When user requests all projects
    Then project with code "PROJCODE" and title "FirstApiUIProject" exists

  Scenario Outline: NFE getting case
    Given case with name "<caseName>" is created
    When user requests created case
    Then case name is "<caseName>"

    Examples:
      | caseName |
      | TEST     |

  Scenario Outline: NFE getting suite
    Given suite with name "<suiteName>" is created
    When user requests created suite
    Then suite name is "<suiteName>"

    Examples:
      | suiteName |
      | TEST      |

  Scenario: AFE getting project with invalid code
    When user requests project with code "INVALID"
    Then status code of get project response is 404

  Scenario: AFE getting suits with invalid url
    When user requests all suites from project with code "PROJCODE"
    Then status code of get suites response is 400

  Scenario Outline: POST creating case in suite
    Given suite with name "ForPOST" is created
    When user creates case with name "<caseName>" in created suite
    Then case with name "<caseName>" is in suite

    Examples:
      | caseName   |
      | CaseToPost |