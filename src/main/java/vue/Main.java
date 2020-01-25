package vue;

import controleur.Connexion;
import controleur.UtilisateurDAO;
import modele.*;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;


public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main( String[] args ) {

        Connexion.init("modeCreate");
        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();

        Utilisateur user = new Utilisateur("user", "1", "User", UtilisateurDAO.SHA512("user"), TypeDeCompte.UTILISATEUR, false, null, null, null);
        Utilisateur admin = new Utilisateur("admin", "2", "Admin", UtilisateurDAO.SHA512("admin"), TypeDeCompte.ADMINISTRATEUR, false, null, null, null);
        Utilisateur superAdmin = new Utilisateur("azer", "3", "Super-admin", UtilisateurDAO.SHA512("azer"), TypeDeCompte.SUPER_ADMINISTRATEUR, false, null, null, null);

        Magasin m1 = new Magasin("magasin1",  user, null, null);
        Magasin m2 = new Magasin("magasin2",  null, null, null);
        user.setMagasin(m1);
        admin.setMagasin(m1);
        superAdmin.setMagasin(m1);

        admin.setMagasinDirige(m1);

        Rayon r1 = new Rayon("Rayon 1", user, null, m1);
        m1.ajouterRayon(r1);

        Rayon r2 = new Rayon("Rayon 2", null, null, m1);
        m1.ajouterRayon(r2);

        Rayon r3 = new Rayon("Rayon 3", null, null, m1);
        m1.ajouterRayon(r3);

        Rayon r4 = new Rayon("Rayon 4", null, null, m2);
        m2.ajouterRayon(r4);

        Rayon r5 = new Rayon("Rayon 5", null, null, m2);
        m2.ajouterRayon(r5);

        Produit p1 = new Produit("produit1", 42, 10, 99, r1, "desc1", "ref1");
        r1.ajouterProduit(p1);
        Produit p2 = new Produit("produit2", 42, 10, 99, r2, "desc2", "ref2");
        r2.ajouterProduit(p2);

        user.setRayonDirige(r1);

        em.persist(m1);
        em.persist(m2);
        em.persist(user);
        em.persist(admin);
        em.persist(superAdmin);

        em.getTransaction().commit();
        em.close();

        Connexion.close();

        logger.fatal("THIS IS A TEST ERROR");
    }

}