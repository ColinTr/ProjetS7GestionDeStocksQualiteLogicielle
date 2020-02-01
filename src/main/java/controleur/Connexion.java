package controleur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.util.HashMap;
import java.util.Map;

public abstract class Connexion {

    private static EntityManagerFactory emf;

    /**
     * Méthode de connnexion de base qui utilise les paramètres de connexion pré renseignés dans persistence.xml
     * @param mode : Le mode de connexion à utiliser
     * @return true si la connexion a été initialisée, false sinon
     */
    public static boolean init(String mode){
        try {
            emf = Persistence.createEntityManagerFactory(mode);
            return true;
        } catch(PersistenceException a){
            return false;
        }
    }

    /**
     * Méthode de connexion de confort qui se connecte en utilisant toutes les informations passées en paramètre
     * @param mode : Le mode de connexion à utiliser
     * @param url : L'url de la bdd
     * @param user : Le nom de compte de connexion à utiliser
     * @param password : Le mot de passe du compte de connexion à utiliser
      * @return true si la connexion a été initialisée, false sino,
     */
    public static boolean init(String mode, String url, String user, String password){
        try {
            Map<String, String> properties = new HashMap<>();
            properties.put("javax.persistence.jdbc.url", url);
            properties.put("javax.persistence.jdbc.user", user);
            properties.put("javax.persistence.jdbc.password", password);
            emf = Persistence.createEntityManagerFactory(mode,properties);
            return true;
        } catch(PersistenceException | NullPointerException a){ //NullPointerException si la connexion est impossible à partir des paramètres
            return false;
        }
    }

    public static void close(){
        emf.close();
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Constructeur par défaut privé pour empêcher l'instanciation d'objets Connexion.
     */
    private Connexion(){}
}
