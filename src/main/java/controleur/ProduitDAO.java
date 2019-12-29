package controleur;

import modele.Produit;
import modele.Rayon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public final class ProduitDAO {

    /**
     * Fonction renvoyant une nouvelle liste correspondant à la liste de tous les produits enregistrés dans l'application.
     * @return liste de tous les produits.
     */
    public static List<Produit> tousLesProduits(){
        List<Produit> listeARetourner = new ArrayList<Produit>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT u FROM Produit u");

        List results = query.getResultList();

        for(Object o : results){
            listeARetourner.add( ((Produit) o) );
        }

        em.close();
        emf.close();

        return listeARetourner;
    }

    /**
     * Fonction renvoyant une nouvelle liste correspondant à la liste de tous les produits d'un rayon donné enregistrés dans l'application.
     * @param rayonDonne rayon dont l'on souhaite la liste de produits.
     * @return liste de tous les produits d'un rayon donné.
     */
    public static List<Produit> tousLesProduits(Rayon rayonDonne){
        List<Produit> listeARetourner = new ArrayList<Produit>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        Rayon rayon = em.find(Rayon.class, rayonDonne);

        for (Produit p: rayon.getListeProduits()){
            listeARetourner.add(p);
        }

        em.close();

        return listeARetourner;
    }

    /**
     * Fonction ajoutant un nouveau produit dans l'application.
     * @param produit produit que l'on ajoute.
     */
    public static void ajouterUnProduit(Produit produit){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(produit);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    /**
     * Fonction supprimant un produit enregistré dans l'application.
     * @param produit produit que l'on supprime.
     */
    public static void supprimerUnProduit(Produit produit){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.remove(produit);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }

        em.close();
        emf.close();
    }

}