package modele;

import java.util.Properties;

public class ParametresBDD {
    private static String adresse;
    private static Properties informationsUtilisateur;

    //Si les attributs sont null au moment on essaie de les récupérer, on les définit avec les valeurs par défaut dans tous les getters :

    public static String getAdresse() {
        parametreDeBase();
        return adresse;
    }

    private static void parametreDeBase(){
        if(adresse == null) {
            adresse = "jdbc:mysql://127.0.0.1/projet_gestion_de_stocks?serverTimezone=UTC";
        }
        if(informationsUtilisateur == null) {
            informationsUtilisateur = new Properties();
            informationsUtilisateur.put("user", "root");
            informationsUtilisateur.put("password", "");
        }
    }

    public static String getUtilisateur() {
        parametreDeBase();
        return informationsUtilisateur.getProperty("user");
    }

    public static String getMotDePasse() {
        parametreDeBase();
        return informationsUtilisateur.getProperty("password");
    }

    public static Properties getInformationsUtilisateur() {
        parametreDeBase();
        return informationsUtilisateur;
    }

    public static void setAdresse(String nouvelleAdresse) {
        adresse = nouvelleAdresse;
    }

    public static void setInformationsUtilisateur(Properties nouvellesInformationsUtilisateur) {
        informationsUtilisateur = nouvellesInformationsUtilisateur;
    }

    /**
     * Constructeur par défaut privé pour empêcher l'instanciation d'objets ParametresBDD.
     */
    private ParametresBDD(){}
}