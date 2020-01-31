Feature: Tests des magasins

  Scenario: Je veux ajouter un rayon à mon magasin
    Given J'ai un magasin
    When J'ajoute un rayon à ce magasin
    Then Ce rayon est dans la liste de ce magasin