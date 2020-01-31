Feature: Tests des rayons

  Scenario: On ajoute un produit au rayon
    Given J'ai un rayon
    When J'ajoute un produit au rayon
    Then Ce produit est dans la liste de produit du rayon

