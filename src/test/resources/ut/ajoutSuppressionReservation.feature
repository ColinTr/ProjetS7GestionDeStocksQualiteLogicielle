Feature: Puis-je ajouter, enlever ou réserver des articles au stock
On peut ajouter des produits si le nombre d'articles à ajouter plus le nombre d'article présents moins le nombre d'articles réservés est supérieur ou égal à 0.
On peut enlever ou réserver des produits si le nombre d'articles à enlever est supérieur ou égal au nombre d'article présents moins la le nombre d'articles réservés.

  Background:
    Given j'ai 10 articles dans mon stock d'articles

  Scenario: Je veux enlever 3 alors que 5 sont réservés
    Given 5 sont réservés
    When j'essaie d'en enlever 3
    Then c'est possible
    And il en reste 7
    And 5 sont réservés

   Scenario: Je veux enlever 3 alors que 8 sont réservés
     Given 8 sont réservés
     When j'essaie d'en enlever 3
     Then c'est impossible
     And il en reste 10
     And 5 sont réservés

   Scenario: Je veux enlever 11 alors que 0 sont réservés
     Given 0 sont réservés
     When j'essaie d'en enlever 11
     Then c'est impossible
     And il en reste 10
     And 0 sont réservés

  Scenario: Je veux enlever 10 alors que 0 sont réservés
    Given 0 sont réservés
    When j'essaie d'en enlever 10
    Then c'est possible
    And il en reste 0
    And 0 sont réservés

   Scenario: Je veux enlever -5 alors que 0 sont réservés
     Given 0 sont réservés
     When j'essaie d'en enlever -5
     Then c'est possible
     And il en reste 15
     And 0 sont réservés

   Scenario: Je veux ajouter 3 alors que 5 sont réservés
     Given 5 sont réservés
     When j'essaie d'en ajouter 3
     Then c'est possible
     And il en reste 13
     And 5 sont réservés

   Scenario: Je veux ajouter 3 alors que 8 sont réservés
     Given 8 sont réservés
     When j'essaie d'en ajouter 3
     Then c'est possible
     And il en reste 13
     And 8 sont réservés

   Scenario: Je veux ajouter -11 alors que 0 sont réservés
     Given 0 sont réservés
     When j'essaie d'en ajouter -11
     Then c'est impossible
     And il en reste 10
     And 0 sont réservés

  Scenario: Je veux ajouter -10 alors que 0 sont réservés
    Given 0 sont réservés
    When j'essaie d'en ajouter -10
    Then c'est possible
    And il en reste 0
    And 0 sont réservés

   Scenario: Je veux ajouter -5 alors que 0 sont réservés
     Given 0 sont réservés
     When j'essaie d'en ajouter -5
     Then c'est possible
     And il en reste 5
     And 0 sont réservés

   Scenario: Je veux en réserver 3 alors que 5 sont réservés
     Given 5 sont réservés
     When j'essaie d'en réserver 3
     Then c'est possible
     And il en reste 10
     And 8 sont réservés

   Scenario: Je veux en réserver 3 alors que 8 sont réservés
     Given 8 sont réservés
     When j'essaie d'en réserver 3
     Then c'est impossible
     And il en reste 10
     And 8 sont réservés