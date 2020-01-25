package controleur;

import modele.Magasin;
import modele.Rayon;
import modele.Utilisateur;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public final class UtilisateurDAO {

    final static Logger logger = Logger.getLogger(UtilisateurDAO.class);

    public static boolean supprimerUtilisateur(int idUtilisateur){
        EntityManager em =  Connexion.getEntityManager();
        em.getTransaction().begin();
        Utilisateur utilisateur = em.find(Utilisateur.class, idUtilisateur);
        try{
            utilisateur.setRayonDirige(null);
            utilisateur.setMagasinDirige(null);
            utilisateur.setMagasin(null);
            em.remove(utilisateur);
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
     * Cette fonction remplace le chef de rayon courant par un nouveau.
     * @param idChef l'id du nouveau chef de rayon.
     * @param idRayon l'id du rayon.
     */
    public static void definirChefRayon(int idChef, int idRayon){
        EntityManager em = Connexion.getEntityManager();

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE rayonDirige = '" + idRayon + "'");

        List results = query.getResultList();
        List<Utilisateur> userList = new ArrayList<>();
        for(Object o : results){
            userList.add( ((Utilisateur) o) );
        }

        //On met à null le rayon dirigé des utilisateurs trouvés
        for(Utilisateur u : userList){
            u = em.find(u.getClass(), u.getIdUtilisateur());
            u.setRayonDirige(null);
        }

        //On le défini comme chef du rayon
        Utilisateur u = em.find(Utilisateur.class, idChef);
        Rayon r = em.find(Rayon.class, idRayon);

        if(u != null){
            u.setRayonDirige(r);
        }

        em.getTransaction().commit();

        em.close();
    }

    /**
     * Cette fonction remplace le chef de magasin courant par un nouveau.
     * @param idChef l'id du nouveau chef de magasin.
     * @param idMagasin l'id du magasin.
     */
    public static void definirChefMagasin(int idChef, int idMagasin){
        EntityManager em = Connexion.getEntityManager();

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE magasinDirige = '" + idMagasin + "'");

        List results = query.getResultList();
        List<Utilisateur> userList = new ArrayList<>();
        for(Object o : results){
            userList.add( ((Utilisateur) o) );
        }

        //On met à null le magasin dirigé des utilisateurs trouvés
        for(Utilisateur u : userList){
            u = em.find(u.getClass(), u.getIdUtilisateur());
            u.setMagasinDirige(null);
        }

        //On le défini comme chef du magasin
        Utilisateur u = em.find(Utilisateur.class, idChef);
        Magasin m = em.find(Magasin.class, idMagasin);

        if(u != null){
            u.setMagasinDirige(m);
        }

        em.getTransaction().commit();

        em.close();
    }

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
     * @return l'utilisateur correspondant (null si inexistant dans la BDD).
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
     * Cette fonction teste si un nom de compte existe déjà dans la base de données.
     * @param ndCompte le nom de compte.
     * @return l'utilisateur correspondant (null si inexistant dans la BDD).
     */
    public static Utilisateur testerNomDeCompte(String ndCompte){
        Utilisateur utilisateur = null;

        EntityManager em = Connexion.getEntityManager();

        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.nomDeCompte = '" + ndCompte + "'");

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
     * Fonction renvoyant une nouvelle liste correspondant à la liste de tous les utilisateurs enregistrés dans l'application.
     * @return liste de tous les utilisateurs.
     */
    public static List<Utilisateur> tousLesUtilisateurs(){
        List<Utilisateur> listeARetourner = new ArrayList<>();

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

    /**
     * Constructeur par défaut privé pour empêcher l'instanciation d'objets UtilisateurDAO.
     */
    private UtilisateurDAO(){}

}