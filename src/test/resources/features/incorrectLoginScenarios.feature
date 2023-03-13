Feature: incorrect log in test for qase.io

  @ui
  Scenario Outline: incorrectData data in login test
    When user inputs incorrect login "<login>"
    Then validation alert "<message>" is presented
    Examples:
      | login            | message                                                                    |
      | sasha.com        | Please include an '@' in the email address. 'sasha.com' is missing an '@'. |
      | sasha @gmail.com | A part followed by '@' should not contain the symbol ' '.                  |
      | @gmail.com       | Please enter a part followed by '@'. '@gmail.com' is incomplete.           |

  #@ui
  Scenario: FAILED login test
   When user logged in
   Then Create new project button is not presented on Projects Page

