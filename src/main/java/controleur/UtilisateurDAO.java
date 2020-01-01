package controleur;

import modele.Magasin;
import modele.Rayon;
import modele.Utilisateur;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public final class UtilisateurDAO {

    /**
     * Fonction permettant de hacher un String selon la fonction Sha512.
     * @param str le String à hacher.
     * @return le String haché.
     */
    public static String SHA512(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(str.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Cette fonction teste si un utilisateur existe dans la base de données ou non.
     * @param ndCompte le nom de compte.
     * @param mdPasse le mot de passe (non haché).
     * @return l'utilisateur correspondant.
     */
    public static Utilisateur testerAuthentification(String ndCompte, String mdPasse){
        Utilisateur utilisateur = null;

        EntityManager em = Connexion.getEntityManager();

        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.motDePasse = '" + SHA512(mdPasse) + "' AND u.nomDeCompte = '" + ndCompte + "'");

        List results = query.getResultList();

        if(!results.isEmpty()){
            utilisateur = (Utilisateur) results.get(0);
        }

        em.close();
        return utilisateur;
    }

    /**
     * Fonction permettant d'ajouter un utilisateur à la base de données.
     * @param utilisateur : l'utilisateur à ajouter à la BDD.
     * @return true si il a pu être ajouté, false sinon.
     */
    public static boolean creerUtilisateur(Utilisateur utilisateur){
        EntityManager em =  Connexion.getEntityManager();

        em.getTransaction().begin();

        if (utilisateur.getMagasinDirige() != null){ utilisateur.setMagasinDirige(em.find(Magasin.class, utilisateur.getMagasinDirige().getIdMagasin())); }
        if (utilisateur.getRayonDirige() != null){ utilisateur.setRayonDirige(em.find(Rayon.class, utilisateur.getRayonDirige().getIdRayon())); }
        if (utilisateur.getMagasin() != null){ utilisateur.setMagasin(em.find(Magasin.class, utilisateur.getMagasin().getIdMagasin())); }

        try{
            em.persist(utilisateur);
        } catch (Exception e){
            e.printStackTrace();
            em.close();
            return false;
        }

        em.getTransaction().commit();
        em.close();
        return true;
    }

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