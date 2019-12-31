Feature: Puis-je ajouter des articles à la base de donnée

  Background:
    Given j'ai 10 produits en local
    Given on est connecté à la bdd

  Scenario: Je veux ajouter 1 a la bdd
    Given 0 dans la bdd
    When j'essaie d'en ajouter 1 a la bdd
    Then on récupere la liste bdd
    And il en y a 1 dans la liste bdd
    And on retrouve les produits inséré dans la liste bdd
    Then la bdd est fermée

  Scenario: Je veux ajouter 5 a la bdd
    Given 0 dans la bdd
    When j'essaie d'en ajouter 5 a la bdd
    Then on récupere la liste bdd
    And il en y a 5 dans la liste bdd
    And on retrouve les produits inséré dans la liste bdd
    Then la bdd est fermée

  Scenario: Je veux ajouter 10 a la bdd
    Given 0 dans la bdd
    When j'essaie d'en ajouter 10 a la bdd
    Then on récupere la liste bdd
    And il en y a 10 dans la liste bdd
    And on retrouve les produits inséré dans la liste bdd
    Then la bdd est fermée

  Scenario: Je veux ajouter 1 a la bdd
    Given 125 dans la bdd
    When j'essaie d'en ajouter 1 a la bdd
    Then on récupere la liste bdd
    And il en y a 126 dans la liste bdd
    And on retrouve les produits inséré dans la liste bdd
    And la bdd est fermée

  Scenario: Je veux ajouter 5 a la bdd
    Given 45 dans la bdd
    When j'essaie d'en ajouter 5 a la bdd
    Then on récupere la liste bdd
    And il en y a 50 dans la liste bdd
    And on retrouve les produits inséré dans la liste bdd
    Then la bdd est fermée

  Scenario: Je veux ajouter 10 a la bdd
    Given 37 dans la bdd
    When j'essaie d'en ajouter 10 a la bdd
    Then on récupere la liste bdd
    And il en y a 47 dans la liste bdd
    And on retrouve les produits inséré dans la liste bdd
    Then la bdd est fermée