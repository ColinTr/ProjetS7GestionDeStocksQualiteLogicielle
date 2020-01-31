Feature: Tests des utilisateurs

  Scenario Outline: Verifier si "<motDePasseATester>" est un mot de passe acceptable
    Given j'ai entre ce mot de passe "<motDePasseATester>"
    When je teste "<motDePasseATester>" pour voir si c'est un mot de passe acceptable
    Then le resultat devrait etre "<valeurRetour>" pour motDePasseATester
    Examples:
      | motDePasseATester | valeurRetour |
      |  | false |
      | a | false |
      | abcdefg | false |
      | abcdefgh | true  |
      | abcdefghij | true |
      | 1234567 | false |
      | 12345678 | true |
      | 1;? 5!8, | true |
      | 1234567891011121314 | true |


  Scenario Outline: Verifier si "<nomDeCompteATester>" est un nom de compte acceptable
    Given j'ai entre ce nom de compte "<nomDeCompteATester>"
    When je teste "<nomDeCompteATester>" pour voir si c'est un nom de compte acceptable
    Then le resultat devrait etre "<valeurRetour>" pour nomDeCompteATester
    Examples:
      | nomDeCompteATester | valeurRetour |
      |  | false |
      | a | false |
      | abc | false |
      | abcd | true |
      | abcdefghij | true |
      | 123 | false |
      | 1234 | true |
      | 123456 | true |
      |      | false |
      |   | false |
      | ab cd | false |