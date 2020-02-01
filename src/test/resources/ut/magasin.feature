Feature: Tests des magasins

  Scenario: Je veux ajouter un rayon à mon magasin
    Given J'ai un magasin
    When J'ajoute un rayon à ce magasin
    Then Ce rayon est dans la liste de ce magasin

  Scenario: On test le constructeur et les getters
    Given Un magasin avec des parametres definis
    Then les informations recuperees par les getters du magasin correspondent

  Scenario: On test les setters et les getters
    Given Un magasin par defaut
    When On change les attributs du magasin par les nouveaux
    Then les informations recuperees par les getters du magasin correspondent