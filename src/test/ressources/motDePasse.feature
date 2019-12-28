Feature: Ce mot de passe est-il acceptable
  Un mot de passe est acceptable si il contient au moins 8 caracteres.
  Scenario Outline: Verifier si <motDePasseATester> est acceptable
    Given j'ai entre ce mot de passe <motDePasseATester>
    When je test <motDePasseATester> pour voir s'il est acceptable
    Then le resultat devrait etre <valeurRetour> pour <motDePasseATester>
    Examples:
      | motDePasseATester | valeurRetour |
      | "" | "false" |
      | "a" | "false" |
      | "abcdefg" | "false" |
      | "abcdefgh" | "true"  |
      | "abcdefghij" | "true" |
      | "1234567" | "false" |
      | "12345678" | "true" |
      | "1;? 5!8" | "true" |
      | "1234567891011121314" | "true" |
      | "        " | "true" |