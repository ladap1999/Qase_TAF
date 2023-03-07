@ui
Feature: incorrect log in test for qase.io

  Scenario Outline: incorrectData data in login test
    When user inputs incorrect "<login>"
    Then validation alert "<message>" is presented
    Examples:
      | login            | message                                                                    |
      | sasha.com        | Please include an '@' in the email address. 'sasha.com' is missing an '@'. |
      | sasha @gmail.com | A part followed by '@' should not contain the symbol ' '.                  |
      | @gmail.com       | Please enter a part followed by '@'. '@gmail.com' is incomplete.           |