package controleur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Connexion {

    private static EntityManagerFactory emf;

    public static void init(String mode){
        emf = Persistence.createEntityManagerFactory(mode);
    }

    public static void close(){
        emf.close();
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
