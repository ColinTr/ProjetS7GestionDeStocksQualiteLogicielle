package controleur;

import modele.Produit;
import modele.Rayon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RayonDAO {

    /**
     * Fonction renvoyant une nouvelle liste correspondant à la liste de tous les rayons enregistrés dans l'application.
     * @return liste de tous les rayons.
     */
    public static List<Rayon> tousLesRayons(){
        List<Rayon> listeARetourner = new ArrayList<Rayon>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT u FROM Rayon u");

        List results = query.getResultList();

        for(Object o : results){
            listeARetourner.add( ((Rayon) o) );
        }

        return listeARetourner;
    }

}
