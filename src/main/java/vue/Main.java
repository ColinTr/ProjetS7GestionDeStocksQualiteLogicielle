package vue;

import controleur.Connexion;
import controleur.ProduitDAO;
import modele.Produit;


public class Main {
    public static void main( String[] args ) {
        Connexion.init();

        Produit a = new Produit("A", 1, 1,1,null);

        ProduitDAO.ajoutStockProduit(a, 40);

        Connexion.close();
    }


}