package controleur;

import modele.Magasin;
import modele.Rayon;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public final class MagasinDAO {

    /**
     * Fonction renvoyant une nouvelle liste correspondant à la liste de tous les rayons de ce magasin
     * @param idMagasin : le magasin dont il faut lister les rayons
     * @return liste de tous les rayons.
     */
    public static List<Rayon> tousLesRayons(int idMagasin){
        List<Rayon> listeARetourner = new ArrayList<>();

        EntityManager em =  Connexion.getEntityManager();

        Query query = em.createQuery("SELECT r FROM Rayon r WHERE magasin = '" + idMagasin + "'");

        List results = query.getResultList();

        for(Object o : results){
            listeARetourner.add( ((Rayon) o) );
        }

        em.close();

        return listeARetourner;
    }

}
