Feature: Tests d'integration sur UtilisateurDAO

  @bdd
  Scenario: On supprime un utilisateur
    Given J'ai un utilisateur sur la base de donnée
    When Je supprime l'utilisateur
    Then Il n'est plus sur la base de donnée

  @bdd
  Scenario: On definie un chef de rayon
    Given J'ai un utilisateur sur la base de donnée
    And J'ai un rayon sur la base de donnée
    When Je définie que l'utilisateur est le chef du rayon
    Then Lorsqu'on recupere le rayon, le chef est bien l'utilisateur

  @bdd
  Scenario: On definie un chef de magasin
    Given J'ai un utilisateur sur la base de donnée
    And J'ai un magasin sur la base de donnée
    When Je définie que l'utilisateur est le chef du magasin
    Then Lorsqu'on recupere le magasin, le chef est bien l'utilisateur

  @bdd
  Scenario: On test l'authentification d'un utilisateur
    Given J'ai un utilisateur sur la base de donnée
    When Je teste l'authentification de cet utilisateur avec le bon mot de passe

  @bdd
  Scenario: On test l'authentification d'un utilisateur
    Given J'ai un utilisateur sur la base de donnée
    When Je teste l'authentification de cet utilisateur avec un mauvais mot de passe

  @bdd
  Scenario: On test le nom de compte d'un utilisateur
    Given J'ai un utilisateur sur la base de donnée
    When Je teste un bon nom de compte

  @bdd
  Scenario: On test le nom de compte d'un utilisateur
    Given J'ai un utilisateur sur la base de donnée
    When Je teste un mauvais nom de compte

  @bdd
  Scenario: On ajoute un utilisateur sur la base de donnée
    Given J'ai un utilisateur
    When Je l'ajoute sur la base de donnée
    Then Il est sur la base de donnée

  @bdd
  Scenario: On recupere les utilisateurs de la base de donnée
    Given J'ai trois utilisateurs sur la base de donnée
    When Je recupere les utilisateurs de la base de donnée
    Then La liste d'utilisateurs recupérés sont les mêmes que ceux insérés

  @bdd
  Scenario: On recupere un utilisateur de la base de donnée
    Given J'ai trois utilisateurs sur la base de donnée
    When Je recupere un utilisateur
    Then L'utilisateur que je recupere est bien le bon