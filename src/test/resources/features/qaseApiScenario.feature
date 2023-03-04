@api
Feature: Api tests for qase.io

  Scenario Outline: NFE getting all projects
    When user requests all projects
    Then project with code "<projectCode>" and title "<projectTitle>" exists

    Examples:
      | projectCode | projectTitle    |
      | FIRSTAPI    | FirstApiProject |


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
      | TEST     |

  Scenario Outline: AFE getting project with invalid code
    When user requests project with code "<projectCode>"
    Then status code is <statusCode>

    Examples:
      | projectCode | statusCode |
      | INVALID     | 404        |
