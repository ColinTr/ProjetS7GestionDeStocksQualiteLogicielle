Feature: On souhaite manipuler des produits sur la base de donnée.

  @bdd
  Scenario Outline: On souhaite récupérer les produits sur la BDD
    Given <number> produits dans la bdd
    When Quand on récupère la bdd et on stock la liste
    Then Alors notre liste BDD contient <number> produits
    Examples:
      | number |
      | 10 |
      | 25 |
      | 120 |
      | 0 |

  @bdd
  Scenario Outline: On souhaite ajouter des produits sur la BDD
    Given <num1> produits dans la bdd
    When On insère <num2> produits à la BDD et on les stocks dans une liste
    Then Alors on récupère la bdd et on stock la liste
    And Et notre liste BDD contient <num1+num2> produits
    And La liste BDD contient les produits de la liste locale
    Examples:
      | num1 | num2 | num1+num2 |
      | 1 | 5 | 6 |
      | 4 | 9 | 13 |
      | 45 | 25 | 70 |
      | 30 | 70 | 100 |

  @bdd
  Scenario Outline: On souhaite supprimer des produits sur la BDD
    Given <num1> produits dans la bdd
    And Et on récupère la bdd et on stock la liste
    When Quand on supprime <num2> produits et qu'on les stocks
    Then Alors on récupère la bdd et on stock la liste
    And Et notre liste BDD contient <num1-num2> produits
    And La liste BDD ne contient pas les produits de la liste locale
    Examples:
      | num1 | num2 | num1-num2 |
      | 5 | 1 | 4 |
      | 10 | 5 | 5 |
      | 25 | 7 | 18 |
      | 100 | 53 | 47 |

  @bdd
  Scenario: On souhaite supprimer des produits qui ne sont pas sur la BDD
    Given 10 produits dans la bdd
    And On remplie la liste BDD avec 5 produits qui ne sont pas sur la BDD
    When Quand on supprime 5 produits et qu'on les stocks


