Feature: Tests d'integration sur MagasinDAO

  @bdd
  Scenario: On recupere tous les magasins de la base de donnee
    Given J'ai trois magasins
    And J'ajoute les trois magasins à la base de donnée
    When Je recupere tous les magasins de la base de donnée
    Then La liste de magasins récupéré est composé des trois magasins insérée au départ