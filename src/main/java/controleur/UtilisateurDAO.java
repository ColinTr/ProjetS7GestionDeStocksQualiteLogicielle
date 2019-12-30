package controleur;

import modele.Utilisateur;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public final class UtilisateurDAO {

    /**
     * Fonction renvoyant une nouvelle liste correspondant à la liste de tous les utilisateurs enregistrés dans l'application.
     * @return liste de tous les utilisateurs.
     */
    public static List<Utilisateur> tousLesUtilisateurs(){
        List<Utilisateur> listeARetourner = new ArrayList<Utilisateur>();

        EntityManager em = Connexion.getEntityManager();

        Query query = em.createQuery("SELECT u FROM Utilisateur u");

        List results = query.getResultList();

        for(Object o : results){
            listeARetourner.add( ((Utilisateur) o) );
        }

        em.close();

        return listeARetourner;
    }

    public static Utilisateur getUtilisateur(String ndCompte, String mdPasse){
        Utilisateur utilisateur = null;

        EntityManager em = Connexion.getEntityManager();

        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.motDePasse = '" + mdPasse + "' AND u.nomDeCompte = '" + ndCompte + "'");

        List results = query.getResultList();

        if(!results.isEmpty()){
            utilisateur = (Utilisateur) results.get(0);
        }

        em.close();
        return utilisateur;
    }

    public static Utilisateur getUtilisateur(int id){
        Utilisateur utilisateur = null;

        EntityManager em = Connexion.getEntityManager();

        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.idUtilisateur = '" + id + "'");

        List results = query.getResultList();

        if(!results.isEmpty()){
            utilisateur = (Utilisateur) results.get(0);
        }

        em.close();
        return utilisateur;
    }

}