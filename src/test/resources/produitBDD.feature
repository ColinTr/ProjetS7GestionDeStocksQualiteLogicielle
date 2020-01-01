Feature: On souhaite manipuler des produits sur la base de donnée.

  @bdd
  Scenario Outline: On récupère les produits sur la BDD
    Given On met <qte> produits dans la bdd et on stock dans la liste locale
    When On récupère la bdd et on la stock dans la liste bdd
    Then La liste bdd fait la taille <qte>
    Then La liste bdd contient les produits de la liste locale
    Examples:
    | qte |
    | 1 |
    | 5 |
    | 10 |
    | 25 |
    | 50 |

  @bdd
  Scenario Outline: On récupère les produits sur la BDD avec l'id
    Given On met <qte> produits dans la bdd et on stock dans la liste locale
    When On récupère la bdd et on la stock dans la liste bdd avec l'id
    Then La liste bdd fait la taille <qte>
    Then La liste bdd contient les produits de la liste locale
    Examples:
      | qte |
      | 1 |
      | 5 |
      | 10 |
      | 25 |
      | 50 |

  @bdd
  Scenario Outline: On ajoute des nouveaux produits sur la bdd
    Given On met <qte> produits dans la bdd et on stock dans la liste locale
    Given On génère <nb> produits dans la liste locale
    When On insère les produits de la liste locale dans la bdd VALIDE
    Then Alors on récupère la bdd et on la stock dans la liste bdd
    Then La liste bdd fait la taille <total>
    Then La liste bdd contient les produits de la liste locale
    Examples:
      | qte | nb | total |
      | 4 | 1 | 5 |
      | 10 | 5 | 15 |
      | 30 | 0 | 30 |
      | 0 | 10 | 10 |
      | 50 | 50 | 100 |

  @bdd
  Scenario Outline: On ajoute des produits déjà présent sur la bdd dans la bdd
    Given On met <qte> produits dans la bdd et on stock dans la liste locale
    When On insère les produits de la liste locale dans la bdd NON VALIDE
    Then Alors on récupère la bdd et on la stock dans la liste bdd
    Then La liste bdd fait la taille <qte>
    Then La liste bdd contient les produits de la liste locale
    Examples:
      | qte |
      | 1 |
      | 5 |
      | 10 |
      | 25 |
      | 50 |

  @bdd
  Scenario Outline: On supprime des produits déjà présent sur la bdd dans la bdd
    Given On met <qte> produits dans la bdd et on stock dans la liste locale
    When On supprime dans la bdd les produits de la liste locale VALIDE
    Then Alors on récupère la bdd et on la stock dans la liste bdd
    Then La liste bdd fait la taille <zero>
    Then La liste bdd ne contient pas les produits de la liste locale
    Examples:
      | qte | zero |
      | 4 | 0 |
      | 10 | 0 |
      | 30 | 0 |
      | 0 | 0 |
      | 50 | 0 |

  @bdd
  Scenario Outline: On supprime des nouveaux produits sur la bdd
    Given On met <qte> produits dans la bdd et on stock dans la liste locale
    Given On génère <nb> produits dans la liste locale
    When On supprime dans la bdd les produits de la liste locale NON VALIDE
    Then Alors on récupère la bdd et on la stock dans la liste bdd
    Then La liste bdd fait la taille <qte>
    Then La liste bdd ne contient pas les produits de la liste locale
    Examples:
      | qte | nb |
      | 1 | 4 |
      | 5 | 10 |
      | 10 | 5 |
      | 25 | 10 |
      | 50 | 30 |

  @bdd
  Scenario Outline: On souhaite supprimer du stock de produits sur la bdd VALIDE
    Given On génère <qte> produits dans la liste locale
    Given On met le stock des produits aléatoirement avec comme minimum <minus>
    Given On insère les produits de la liste locale dans la bdd VALIDE
    When On supprime <minus> au stock de tout les produits de la liste locale sur la bdd VALIDE
    Then On récupère la bdd et on la stock dans la liste bdd
    Then Tous les produits ont leurs stock initial moins <minus>
    Examples:
      | qte | minus |
      | 5 | 1 |
      | 10 | 5 |
      | 25 | 7 |
      | 50 | 53 |
      | 100 | 44 |

  @bdd
  Scenario Outline: On souhaite supprimer du stock de produits sur la bdd VALIDE
    Given On génère <qte> produits dans la liste locale
    Given On met le stock des produits aléatoirement avec comme minimum <minus>
    Given On insère les produits de la liste locale dans la bdd VALIDE
    When On supprime <minus> au stock de tout les produits de la liste locale sur la bdd VALIDE
    Then On récupère la bdd et on la stock dans la liste bdd
    Then Tous les produits ont leurs stock initial moins <minus>
    Examples:
      | qte | minus |
      | 5 | 1 |
      | 10 | 5 |
      | 25 | 7 |
      | 50 | 53 |
      | 100 | 44 |

  @bdd
  Scenario Outline: On souhaite supprimer du stock de produits sur la bdd NON VALIDE
    Given On génère <qte> produits dans la liste locale
    Given On met le stock des produits aléatoirement avec comme maximum <max>
    Given On insère les produits de la liste locale dans la bdd VALIDE
    When On supprime <max> au stock de tout les produits de la liste locale sur la bdd NON VALIDE
    Then On récupère la bdd et on la stock dans la liste bdd
    Then Tous les produits ont leurs stock initial
    Examples:
      | qte | max |
      | 5 | 1 |
      | 10 | 5 |
      | 25 | 7 |
      | 50 | 53 |
      | 100 | 44 |
