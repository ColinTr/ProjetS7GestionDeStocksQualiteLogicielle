Feature: Tests d'intégrations sur RayonDAO

  @bdd
  Scenario: On recupere tous les produits d'un rayon donne
    Given J'ai deux produits dans un rayon X et un produit dans rayon Y
    And J'ajoute les trois produits et les deux rayons a la base de donnees
    When Je recupere tous les produits du rayon X
    Then La liste recuperee est composee des produits du rayon X

  @bdd
  Scenario: On recupere tous les rayons de la base de donnees
    Given J'ajoute deux rayons X et Y a la base de donnees
    When Je recupere tous les rayons
    Then La liste recuperee possede les deux memes rayons

  @bdd
  Scenario: On cherche on rayon a partir de son id
    Given J'ajoute deux rayons X et Y a la base de donnees
    When Je cherche le rayon X a partir de son id
    Then Le rayon recupere est X