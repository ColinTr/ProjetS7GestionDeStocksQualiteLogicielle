package controleur;

import modele.Utilisateur;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {

    /**
     * Fonction renvoyant une nouvelle liste correspondant à la liste de tous les utilisateurs enregistrés dans l'application.
     * @return liste de tous les utilisateurs.
     */
    public static List<Utilisateur> tousLesUtilisateurs(){
        List<Utilisateur> listeARetourner = new ArrayList<Utilisateur>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("classique");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT u FROM Utilisateur u");

        List results = query.getResultList();

        for(Object o : results){
            listeARetourner.add( ((Utilisateur) o) );
        }

        em.close();

        return listeARetourner;
    }

}
