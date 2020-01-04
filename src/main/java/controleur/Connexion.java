package controleur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.util.HashMap;
import java.util.Map;


public abstract class Connexion {

    private static EntityManagerFactory emf;

    public static boolean init(String mode){
        try {
            emf = Persistence.createEntityManagerFactory(mode);
            return true;
        } catch(PersistenceException a){
            return false;
        }
    }

    public static void init(String mode, String url, String user, String password){
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", url);
        properties.put("javax.persistence.jdbc.user", user);
        properties.put("javax.persistence.jdbc.password", password);
        emf = Persistence.createEntityManagerFactory(mode,properties);
    }


    public static void close(){
        emf.close();
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
