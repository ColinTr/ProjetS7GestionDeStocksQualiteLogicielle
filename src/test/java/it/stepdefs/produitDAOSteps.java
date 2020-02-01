package it.stepdefs;

import controleur.Connexion;
import controleur.ProduitDAO;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modele.Produit;
import modele.Rayon;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class produitDAOSteps {


    Produit produit;
    Produit produitRecupere;

    @Given("J'ai un produit")
    public void jAiUnProduit() {
        produit = new Produit();
    }

    @And("J'ajoute le produit à la bdd")
    public void jeLAjouteÀLaBdd() {
        assertTrue(ProduitDAO.ajouterUnProduit(produit));
    }

    @When("Je récupère le produit sur la base de donnée")
    public void jeRécupèreLeProduitSurLaBaseDeDonnée() {
        produitRecupere = ProduitDAO.trouverProduit(produit.getIdProduit());
    }

    @Then("Le produit récupéré est le même que celui ajouté")
    public void leProduitRécupéréEstLeMêmeQueCeluiAjouté() {
        assertEquals(produit, produitRecupere);
    }

    boolean res1;
    boolean res2;

    @When("J'ajoute le produit deux fois à la bdd")
    public void jeLAjouteDeuxFoisÀLaBdd() {
        res1 = ProduitDAO.ajouterUnProduit(produit);
        res2 = ProduitDAO.ajouterUnProduit(produit);
    }

    @Then("Le premier fonctionne mais pas le deuxième")
    public void lePremierFonctionneMaisPasLeDeuxième() {
        assertTrue(res1);
        assertFalse(res2);
    }

    @When("Je supprime le produit de la bdd")
    public void jeSupprimeLeProduitDeLaBdd() {
        assertTrue(ProduitDAO.supprimerUnProduit(produit.getIdProduit()));
    }

    @Then("Je ne trouve pas le produit sur la bdd")
    public void jeNeTrouvePasLeProduitSurLaBdd() {
        assertNull(ProduitDAO.trouverProduit(produit.getIdProduit()));
    }

    List<Produit> produits = new ArrayList<Produit>();

    @Given("J'ai trois produits")
    public void jAiTroisProduits() {
        produits.add(new Produit());
        produits.add(new Produit());
        produits.add(new Produit());
    }

    @And("J'ajoute les trois produits à la base de donnée")
    public void jAjouteLesTroisProduitsÀLaBaseDeDonnée() {
        ProduitDAO.ajouterUnProduit(produits.get(0));
        ProduitDAO.ajouterUnProduit(produits.get(1));
        ProduitDAO.ajouterUnProduit(produits.get(2));
    }

    List<Produit> produitsBDD = new ArrayList<Produit>();

    @When("Je recupere tous les produits de la base de donnée")
    public void jeRecupereTousLesProduitsDeLaBaseDeDonnée() {
        produitsBDD = ProduitDAO.tousLesProduits();
    }

    @Then("La liste de produit récupéré est composé des trois produits insérée au départ")
    public void laListeDeProduitRécupéréEstComposéDesTroisProduitsInséréeAuDépart() {
        for (Produit p : produits) {
            assertThat(produitsBDD, hasItem(p));
        }
    }

    Produit produit1;
    Produit produit2;
    Produit produit3;

    Rayon A;
    Rayon B;

    List<Produit> produitRayonA = new ArrayList<Produit>();

    @Given("J'ai deux produits avec un rayon A et un produit avec rayon B")
    public void jAiDeuxProduitsAvecUnRayonAEtUnProduitAvecRayonB() {
        produitsBDD.clear();
        produits.clear();

        A = new Rayon("A",null, new ArrayList<Produit>(),null);
        B = new Rayon("B",null, new ArrayList<Produit>(),null);

        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();
        em.persist(A);
        em.persist(B);
        em.getTransaction().commit();
        em.close();

        produit1 = new Produit();
        produit1.setRayon(A);

        produit2 = new Produit();
        produit2.setRayon(A);

        produit3 = new Produit();
        produit3.setRayon(B);

        produitRayonA.add(produit1);
        produitRayonA.add(produit2);
    }

    @And("J'ajoute les trois produits et les deux rayons à la base de donnée")
    public void jAjouteLesTroisProduitsEtLesDeuxRayonsÀLaBaseDeDonnée() {
        ProduitDAO.ajouterUnProduit(produit1);
        ProduitDAO.ajouterUnProduit(produit2);
        ProduitDAO.ajouterUnProduit(produit3);
    }

    @When("Je recupere tous les produits du rayon A")
    public void jeRecupereTousLesProduitsDuRayonA() {
        produitsBDD = ProduitDAO.tousLesProduits(A);
    }

    @Then("La liste récupérée est composé des produits du rayon A")
    public void laListeRécupéréeEstComposéDesProduitsDuRayonA() {
        for (Produit p: produitRayonA) {
            boolean present = false;
            for (Produit pBdd: produitsBDD) {
                if (p.getIdProduit() == pBdd.getIdProduit()){
                    present = true;
                    break;
                }
            }
            assertTrue(present);
        }
    }

    @Given("J'ai un produit avec un stock de {int}")
    public void jAiUnProduitAvecUnStockDe(int arg0) {
        produit = new Produit("Tomate",arg0,0,0,null,"","");
    }

    boolean resultat;

    @When("J'ajoute {int} de stock au produit sur la bdd")
    public void jAjouteDeStockAuProduitSurLaBdd(int arg0) {
        resultat = ProduitDAO.ajoutStockProduit(produit, arg0);
    }

    @And("Je recupere le produit")
    public void jeRecupereLeProduit() {
        EntityManager em = Connexion.getEntityManager();
        produit = em.find(Produit.class, produit.getIdProduit());
        em.close();
    }

    @Then("Le stock du produit est de {int}")
    public void leStockDuProduitEstDe(int arg0) {
        assertEquals(produit.getStock(), arg0);
    }

    @When("Je supprime {int} de stock au produit sur la bdd")
    public void jeSupprimeDeStockAuProduitSurLaBdd(int arg0) {
        ProduitDAO.suppressionStockProduit(produit, arg0);
    }

    @Then("Cela echoue")
    public void celaEchoue() {
        assertFalse(resultat);
    }
}