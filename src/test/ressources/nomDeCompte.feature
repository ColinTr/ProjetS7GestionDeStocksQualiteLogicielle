Feature: Ce nom de compte est-il acceptable
  #Un nom de compte est acceptable si il contient au moins 4 caracteres et aucun caractere espace.
  Scenario Outline: Verifier si <nomDeCompteATester> est acceptable
    Given j'ai entre ce nom de compte <nomDeCompteATester>
    When je test <nomDeCompteATester> pour voir s'il est acceptable
    Then le resultat devrait etre <valeurRetour> pour <nomDeCompteATester>
    Examples:
      | nomDeCompteATester | valeurRetour |
      | "" | "false" |
      | "a" | "false" |
      | "abc" | "false" |
      | "abcd" | "true" |
      | "abcdefghij" | "true" |
      | "123" | "false" |
      | "1234" | "true" |
      | "123456" | "true" |
      | "    " | "false" |
      | " " | "false" |
      | "ab cd" | "false" |