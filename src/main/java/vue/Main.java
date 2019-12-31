package vue;

import controleur.Connexion;
import controleur.MagasinDAO;
import modele.*;

import javax.persistence.EntityManager;


public class Main {
    public static void main( String[] args ) {

        Connexion.init("modeCreate");
        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();


        //Magasin de test :
        Utilisateur colin = new Utilisateur("azer", "Colin", "Troisemaine", "azer", TypeDeCompte.ADMINISTRATEUR, false, null, null, null);

        Magasin m1 = new Magasin("magasin1",  colin, null, null);

        Rayon r1 = new Rayon("Rayon 1", colin, null, m1);
        Rayon r2 = new Rayon("Rayon 2", null, null, m1);
        Rayon r3 = new Rayon("Rayon 3", null, null, m1);
        Rayon r4 = new Rayon("Rayon 4", null, null, m1);

        Produit p1 = new Produit("produit1", 42, 10, 99, r1, "desc", "ref");

        colin.setMagasin(m1);
        colin.setRayonDirige(r1);
        r1.ajouterProduit(p1);
        m1.ajouterRayon(r1);
        m1.ajouterRayon(r2);
        m1.ajouterRayon(r3);
        m1.ajouterRayon(r4);

        em.persist(m1);

        em.getTransaction().commit();
        em.close();


        em = Connexion.getEntityManager();
        em.merge(m1);

        em.close();

        Connexion.close();
    }

}