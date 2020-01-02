package stepdefs;

import controleur.Connexion;
import io.cucumber.java.After;
import io.cucumber.java.Before;

//@DisplayName("Classe d'implémentation de la base de donnée")
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
