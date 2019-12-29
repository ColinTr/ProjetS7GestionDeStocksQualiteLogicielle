package vue;

import controleur.UtilisateurDAO;
import modele.Utilisateur;

import javax.persistence.*;

public class Main {

    public static void main( String[] args ) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("classique");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Utilisateur a = new Utilisateur();
        a.setPrenom("Colin");
        a.setNom("Troisemaine");
        em.persist(a);

        em.getTransaction().commit();

        em.close();

        System.out.println((UtilisateurDAO.tousLesUtilisateurs()).get(0));
    }

}