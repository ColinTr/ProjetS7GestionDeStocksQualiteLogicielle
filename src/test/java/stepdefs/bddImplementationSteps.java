package stepdefs;

import controleur.Connexion;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Classe d'implémentation de la base de donnée")
public class bddImplementationSteps {

    @Before("@bdd")
    public void connectionBDD() {
        Connexion.init("testUnit");
    }

    @After("@bdd")
    public void closeConnectionBDD() {
        Connexion.close();
    }

}
