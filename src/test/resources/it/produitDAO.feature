Feature: Tests d'intégrations sur ProduitDAO

  @bdd
  Scenario: On ajoute un produit à la bdd puis on le récupère
    Given J'ai un produit
    And J'ajoute le produit à la bdd
    When Je récupère le produit sur la base de donnée
    Then Le produit récupéré est le même que celui ajouté

  @bdd
  Scenario: On ajoute un produit deux fois sur la bdd
    Given J'ai un produit
    When J'ajoute le produit deux fois à la bdd
    Then Le premier fonctionne mais pas le deuxième

  @bdd
  Scenario: On supprime un objet que l'on vient d'ajouter à la bdd
    Given J'ai un produit
    And J'ajoute le produit à la bdd
    When Je supprime le produit de la bdd
    Then Je ne trouve pas le produit sur la bdd

  @bdd
  Scenario: On recupere tous les produits de la base de donnee
    Given J'ai trois produits
    And J'ajoute les trois produits à la base de donnée
    When Je recupere tous les produits de la base de donnée
    Then La liste de produit récupéré est composé des trois produits insérée au départ

  @bdd
  Scenario: On recupere tous les produits d'un rayon donnee
    Given J'ai deux produits avec un rayon A et un produit avec rayon B
    And J'ajoute les trois produits et les deux rayons à la base de donnée
    When Je recupere tous les produits du rayon A
    Then La liste récupérée est composé des produits du rayon A

  @bdd
  Scenario: On ajoute du stock à un produit
      Given J'ai un produit avec un stock de 3
      And J'ajoute le produit à la bdd
      When J'ajoute 4 de stock au produit sur la bdd
      And Je recupere le produit
      Then Le stock du produit est de 7


  @bdd
  Scenario: On supprime du stock à un produit
    Given J'ai un produit avec un stock de 4
    And J'ajoute le produit à la bdd
    When Je supprime 3 de stock au produit sur la bdd
    And Je recupere le produit
    Then Le stock du produit est de 1

  @bdd
  Scenario: On supprime du stock à un produit
    Given J'ai un produit avec un stock de 4
    And J'ajoute le produit à la bdd
    When Je supprime 5 de stock au produit sur la bdd
    Then Cela echoue