Feature: Tests d'integration sur MagasinDAO

  @bdd
  Scenario: On recupere tous les magasins de la base de donnee
    Given J'ai trois magasins
    And J'ajoute les trois magasins à la base de donnée
    When Je recupere tous les magasins de la base de donnée
    Then La liste de magasins récupéré est composé des trois magasins insérée au départ

  @bdd
  Scenario: On recupere tous les rayons d'un magasin de la base de donnee
    Given J'ai deux rayons du magasin A et un rayon du magasin B
    And J'ajoute les objets à la base de donnée
    When Je recupere tous les rayons du magasin A de la base de donnée
    Then La liste des rayons récupéré est composé des rayons du magasin A insérée au départ