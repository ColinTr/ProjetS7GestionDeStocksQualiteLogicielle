package it.stepdefs;

import controleur.Connexion;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DAOSteps {

    /* === Récupération de la Base de donnée === */

    @Before("@bdd")
    public void connectionBDD() {
        Connexion.init("testUnit");
    }

    @After("@bdd")
    public void closeConnectionBDD() {
        Connexion.close();
    }

}
