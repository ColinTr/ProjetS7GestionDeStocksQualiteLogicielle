package it.stepdefs;

import controleur.Connexion;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import modele.Produit;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.internal.matchers.NotNull;
import org.powermock.api.mockito.PowerMockito;


import javax.persistence.EntityManager;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

//@DisplayName("Classe d'implémentation de la base de donnée")
public class bddImplementationSteps {

    public static List<Produit> produitsBDD;

    @Before("@bdd")
    public void connectionBDD() {
        Connexion.init("testUnit");
    }

    @After("@bdd")
    public void closeConnectionBDD() {
        Connexion.close();
    }


}
