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

    public static boolean testerParametresDeConnexion(String ndCompte, String mdPasse){
        boolean resultat = false;

        EntityManager em = Connexion.getEntityManager();

        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.motDePasse = '" + mdPasse + "' AND u.nomDeCompte = '" + ndCompte + "'");

        List results = query.getResultList();

        if(!results.isEmpty()){
            resultat = true;
        }

        em.close();
        return resultat;
    }

}