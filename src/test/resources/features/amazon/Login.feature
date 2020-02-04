Feature: User login

  Background:
    Given User is on the main page

  Scenario Outline: Login Negative Positive Tests
    When User click on the sign in
    And User enters '<email>' and '<password>'
    Then User Login should be '<result>'

    Examples:
      | email                | password    | result |
      | devxschool@gmail.com | Batch2019   | DevX   |
      | johnDoe@gmail.com    | InvalidPass | Fail   |

