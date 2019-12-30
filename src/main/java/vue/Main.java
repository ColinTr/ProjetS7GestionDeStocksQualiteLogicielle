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

        Rayon r1 = new Rayon("Rayon 1", colin, null, null);

        Produit p1 = new Produit("produit1", 42, 10, 99, r1);

        colin.setMagasin(m1);
        colin.setRayonDirige(r1);
        r1.ajouterProduit(p1);
        r1.setMagasin(m1);
        m1.ajouterRayon(r1);

        em.persist(m1);

        em.getTransaction().commit();
        em.close();




        System.out.println(MagasinDAO.tousLesRayons(m1).size());




        Connexion.close();
    }

}