Feature: Puis-je enlever ou réserver des articles au stock
On peut enlever ou réserver des produits si le nombre d'articles à enlever est inférieur ou égal au nombre d'article présents moins le nombre d'articles réservés.

  Background:
    Given j'ai 10 articles dans mon stock d'articles

  Scenario: Je veux enlever 3 alors que 5 sont réservés
    Given 5 sont réservés
    When j'essaie d'en enlever 3
    Then c'est possible
    And il en reste 7

   Scenario: Je veux enlever 3 alors que 8 sont réservés
     Given 8 sont réservés
     When j'essaie d'en enlever 3
     Then c'est impossible
     And il en reste 10

   Scenario: Je veux en réserver 3 alors que 5 sont réservés
     Given 5 sont réservés
     When j'essaie d'en réserver 3
     Then c'est possible
     And il en reste 7

   Scenario: Je veux en réserver 3 alors que 8 sont réservés
     Given 8 sont réservés
     When j'essaie d'en réserver 3
     Then c'est impossible
     And il en reste 10