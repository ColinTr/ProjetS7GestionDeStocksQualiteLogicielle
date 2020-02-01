Feature: Tests des rayons

  Scenario: On ajoute un produit au rayon
    Given J'ai un rayon
    When J'ajoute un produit au rayon
    Then Ce produit est dans la liste de produit du rayon

  Scenario: On test le constructeur et les getters
    Given Un rayon avec des parametres definis
    Then les informations recuperees par les getters du rayon correspondent

  Scenario: On test les setters et les getters
    Given Un rayon par defaut
    When On change les attributs du rayon par les nouveaux
    Then les informations recuperees par les getters du rayon correspondent