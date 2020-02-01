package it.stepdefs;

import controleur.Connexion;
import controleur.MagasinDAO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modele.Magasin;
import modele.Rayon;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

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

    Magasin magasinA;
    Magasin magasinB;

    @Given("J'ai deux rayons du magasin A et un rayon du magasin B")
    public void jAiDeuxRayonsDuMagasinAEtUnRayonDuMagasinB() {
        magasinA = new Magasin("A", null,new ArrayList<>(),null);
        magasinB = new Magasin("A", null,new ArrayList<>(),null);

        magasinA.ajouterRayon(new Rayon("",null,null,magasinA));
        magasinA.ajouterRayon(new Rayon("",null,null,magasinA));

        magasinB.ajouterRayon(new Rayon("",null,null,magasinB));
    }

    @And("J'ajoute les objets à la base de donnée")
    public void jAjouteLesObjetsÀLaBaseDeDonnée() {
        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();

        em.persist(magasinA);
        em.persist(magasinB);

        for (Rayon r : magasinA.getListeRayons()) {
            em.persist(r);
        }
        for (Rayon r : magasinB.getListeRayons()) {
            em.persist(r);
        }

        em.getTransaction().commit();
    }

    List<Rayon> rayonsBdd;

    @When("Je recupere tous les rayons du magasin A de la base de donnée")
    public void jeRecupereTousLesRayonsDuMagasinADeLaBaseDeDonnée() {
        rayonsBdd = MagasinDAO.tousLesRayons(magasinA.getIdMagasin());
    }

    @Then("La liste des rayons récupéré est composé des rayons du magasin A insérée au départ")
    public void laListeDesRayonsRécupéréEstComposéDesRayonsDuMagasinAInséréeAuDépart() {
        List<Rayon> rayonsMagasin = magasinA.getListeRayons();
        for (Rayon r: rayonsMagasin) {
            boolean present = false;
            for (Rayon rBdd: rayonsBdd) {
                if (r.getIdRayon() == rBdd.getIdRayon()){
                    present = true;
                    break;
                }
            }
            assertTrue(present);
        }
    }
}
