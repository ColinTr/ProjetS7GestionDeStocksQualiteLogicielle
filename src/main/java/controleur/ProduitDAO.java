package controleur;

import modele.Produit;
import modele.Rayon;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public final class ProduitDAO {

    final static Logger logger = Logger.getLogger(ProduitDAO.class);

    /**
     * Fonction renvoyant une nouvelle liste correspondant à la liste de tous les produits enregistrés dans l'application.
     * @return liste de tous les produits.
     */
    public static Produit trouverProduit(int idProduit){
        Produit produitARetourner = null;

        EntityManager em =  Connexion.getEntityManager();

        Query query = em.createQuery("SELECT p FROM Produit p WHERE p.idProduit = '" + idProduit + "'");

        List results = query.getResultList();

        if(!results.isEmpty()){
            produitARetourner = (Produit) results.get(0);
        }

        em.close();

        return produitARetourner;
    }

    /**
     * Fonction renvoyant une nouvelle liste correspondant à la liste de tous les produits enregistrés dans l'application.
     * @return liste de tous les produits.
     */
    public static List<Produit> tousLesProduits(){
        List<Produit> listeARetourner = new ArrayList<>();

        EntityManager em =  Connexion.getEntityManager();

        Query query = em.createQuery("SELECT u FROM Produit u");
        List results = query.getResultList();

        for(Object o : results){
            listeARetourner.add( ((Produit) o) );
        }

        em.close();
        return listeARetourner;
    }

    /**
     * Fonction renvoyant une nouvelle liste correspondant à la liste de tous les produits d'un rayon donné enregistrés dans l'application.
     * @param rayonDonne rayon dont l'on souhaite la liste de produits.
     * @return liste de tous les produits d'un rayon donné.
     */
    public static List<Produit> tousLesProduits(Rayon rayonDonne){
        EntityManager em = Connexion.getEntityManager();

        Rayon rayon = em.find(Rayon.class, rayonDonne.getIdRayon());

        List<Produit> listeARetourner = new ArrayList<>(rayon.getListeProduits());

        em.close();
        return listeARetourner;
    }

    /**
     * Fonction ajoutant un nouveau produit dans l'application.
     * @param produit produit que l'on ajoute.
     * @return true si il a pu être ajouté, false sinon.
     */
    public static boolean ajouterUnProduit(Produit produit){

        EntityManager em =  Connexion.getEntityManager();

        em.getTransaction().begin();

        if (produit.getRayon() != null) {produit.setRayon(em.find(Rayon.class, produit.getRayon().getIdRayon()));}

        try{
            em.persist(produit);
        } catch (Exception e){
            logger.fatal(e);
            em.getTransaction().rollback();
            em.close();
            return false;
        }

        em.getTransaction().commit();
        em.close();
        return true;
    }


    /**
     * Fonction supprimant un produit enregistré dans l'application.
     * @param p produit que l'on supprime.
     * @return true si il a pu être supprimé, false sinon.
     */
    public static boolean supprimerUnProduit(Produit p){

        EntityManager em =  Connexion.getEntityManager();
        em.getTransaction().begin();
        Produit produit = em.find(Produit.class, p.getIdProduit());
        try{
            produit.setRayon(null);
            em.remove(produit);
        } catch (Exception e){
            logger.fatal(e);
            em.getTransaction().rollback();
            em.close();
            return false;
        }

        em.getTransaction().commit();
        em.close();
        return true;
    }

    /**
     * Fonction supprimant un produit enregistré dans l'application.
     * @param id : id du produit que l'on supprime.
     * @return true si il a pu être supprimé, false sinon.
     */
    public static boolean supprimerUnProduit(int id){

        EntityManager em =  Connexion.getEntityManager();

        em.getTransaction().begin();

        Produit produit = em.find(Produit.class, id);

        try{
            produit.setRayon(null);
            em.remove(produit);
        } catch (Exception e){
            logger.fatal(e);
            em.getTransaction().rollback();
            em.close();
            return false;
        }

        em.getTransaction().commit();
        em.close();
        return true;
    }

    public static boolean suppressionStockProduit(Produit p, int quantite){
        EntityManager em = Connexion.getEntityManager();

        em.getTransaction().begin();

        Produit produit = em.find(Produit.class, p.getIdProduit());

        if (produit != null && produit.suppression(quantite)) {
            em.getTransaction().commit();
            em.close();
            return true;
        }

        em.getTransaction().rollback();
        em.close();
        return false;
    }

    public static boolean ajoutStockProduit(Produit p, int quantite){
        EntityManager em = Connexion.getEntityManager();

        em.getTransaction().begin();
        Produit produit = em.find(Produit.class, p.getIdProduit());

        if (produit != null && produit.ajout(quantite)) {
            em.getTransaction().commit();
            em.close();
            return true;
        }

        em.getTransaction().rollback();
        em.close();
        return false;
    }

    /**
     * Constructeur par défaut privé pour empêcher l'instanciation d'objets ProduitDAO.
     */
    private ProduitDAO(){}
}
