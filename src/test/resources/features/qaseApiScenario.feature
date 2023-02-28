@api
Feature: Api tests for qase.io

  Scenario Outline: getting all projects
    When user requests all projects
    Then project with code "<projectCode>" and title "<projectTitle>" exists

    Examples:
      | projectCode | projectTitle    |
      | FIRSTAPI    | FirstApiProject |


