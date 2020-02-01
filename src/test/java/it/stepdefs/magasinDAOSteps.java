package it.stepdefs;

import controleur.Connexion;
import controleur.MagasinDAO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modele.Magasin;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class magasinDAOSteps {

    List<Magasin> magasins = new ArrayList<>();

    @Given("J'ai trois magasins")
    public void jAiTroisMagasins() {
        magasins.add(new Magasin("A",null,null,null));
        magasins.add(new Magasin("B",null,null,null));
        magasins.add(new Magasin("C",null,null,null));
    }


    @And("J'ajoute les trois magasins à la base de donnée")
    public void jAjouteLesTroisMagasinsÀLaBaseDeDonnée() {
        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();
        for (Magasin m: magasins) {
            em.persist(m);
        }
        em.getTransaction().commit();
    }

    List<Magasin> magasinsBdd = new ArrayList<>();

    @When("Je recupere tous les magasins de la base de donnée")
    public void jeRecupereTousLesMagasinsDeLaBaseDeDonnée() {
        magasinsBdd = MagasinDAO.tousLesMagasins();
    }

    @Then("La liste de magasins récupéré est composé des trois magasins insérée au départ")
    public void laListeDeMagasinsRécupéréEstComposéDesTroisMagasinsInséréeAuDépart() {
        for (Magasin m: magasins) {
            boolean present = false;
            for (Magasin mBdd: magasinsBdd) {
                if (m.getIdMagasin() == mBdd.getIdMagasin()){
                    present = true;
                    break;
                }
            }
            assertTrue(present);
        }
    }
}
