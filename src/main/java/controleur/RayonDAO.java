package controleur;

import modele.Magasin;
import modele.Produit;
import modele.Rayon;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public final class RayonDAO {



    /**
     * Fonction renvoyant une nouvelle liste correspondant à la liste de tous les produits de ce rayon
     * @param idRayon : l'id du rayon dont il faut lister les produits
     * @return liste de tous les produits.
     */
    public static List<Produit> tousLesProduits(int idRayon){
        List<Produit> listeARetourner = new ArrayList<>();

        EntityManager em =  Connexion.getEntityManager();

        Query query = em.createQuery("SELECT p FROM Produit p WHERE rayon = '" + idRayon + "'");

        List results = query.getResultList();

        for(Object o : results){
            listeARetourner.add( ((Produit) o) );
        }

        em.close();

        return listeARetourner;
    }

    /**
     * Fonction renvoyant une nouvelle liste correspondant à la liste de tous les rayons enregistrés dans l'application.
     * @return liste de tous les rayons.
     */
    public static List<Rayon> tousLesRayons(){
        List<Rayon> listeARetourner = new ArrayList<Rayon>();

        EntityManager em = Connexion.getEntityManager();

        Query query = em.createQuery("SELECT r FROM Rayon r");

        List results = query.getResultList();

        for(Object o : results){
            listeARetourner.add( ((Rayon) o) );
        }

        em.close();

        return listeARetourner;
    }

}