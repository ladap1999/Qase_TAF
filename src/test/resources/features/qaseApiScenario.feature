@api
Feature: Api tests for qase.io

  Scenario Outline: getting all projects
    When user requests all projects
    Then project with code "<projectCode>" and title "<projectTitle>" exists

    Examples:
      | projectCode | projectTitle    |
      | FIRSTAPI    | FirstApiProject |

  Scenario Outline: getting project with invalid code
    When user requests project with code "<projectCode>"
    Then status code is <statusCode>

    Examples:
      | projectCode | statusCode |
      | INVALID     | 404        |

  Scenario Outline: getting case
    Given case with name "<caseName>" is created
    When user requests created case
    Then case name is "<caseName>"

    Examples:
      | caseName |
      | TEST     |
