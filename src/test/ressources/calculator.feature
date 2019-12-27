Feature: Titre de la fonctionnalité
  Description de la fonctionnalité

  Scenario Outline: Add two numbers <num1> & <num2>
    Given I have a calculator
    When I add <num1> and <num2>
    Then the result should be <total>

    Examples:
      | num1 | num2 | total |
      | -2 | 3 | 1 |
      | 10 | 15 | 25 |
      | 99 | -99 | 0 |
      | -1 | -10 | -11 |