package controleur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connexion {

    private static EntityManagerFactory emf;

    public static void init(){
        emf = Persistence.createEntityManagerFactory("classique");
    }

    public static void close(){
        emf.close();
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
