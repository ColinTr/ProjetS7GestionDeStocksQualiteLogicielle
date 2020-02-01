package it.stepdefs;

import controleur.Connexion;
import controleur.ProduitDAO;
import controleur.RayonDAO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modele.Produit;
import modele.Rayon;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class rayonDAOSteps {

    /* === Récupération de la Base de donnée === */

    @Before("@bdd")
    public void connectionBDD() {
        Connexion.init("testUnit");
    }

    @After("@bdd")
    public void closeConnectionBDD() {
        Connexion.close();
    }

    Rayon X;
    Rayon Y;
    List<Produit> produitsRayonX = new ArrayList<>();
    Produit produit1;
    Produit produit2;
    Produit produit3;

    @Given("J'ai deux produits dans un rayon X et un produit dans rayon Y")
    public void jAiDeuxProduitsDansUnRayonXEtUnProduitDansRayonY() {
        X = new Rayon("X",null, new ArrayList<>(),null);
        Y = new Rayon("Y",null, new ArrayList<>(),null);

        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();
        em.persist(X);
        em.persist(Y);
        em.getTransaction().commit();
        em.close();

        produit1 = new Produit();
        produit1.setRayon(X);
        produit2 = new Produit();
        produit2.setRayon(X);

        produit3 = new Produit();
        produit3.setRayon(Y);

        produitsRayonX.add(produit1);
        produitsRayonX.add(produit2);
    }

    @And("J'ajoute les trois produits et les deux rayons a la base de donnees")
    public void jAjouteLesTroisProduitsEtLesDeuxRayonsALaBaseDeDonnees() {
        ProduitDAO.ajouterUnProduit(produit1);
        ProduitDAO.ajouterUnProduit(produit2);
        ProduitDAO.ajouterUnProduit(produit3);
    }

    List<Produit> produitsBDD = new ArrayList<>();

    @When("Je recupere tous les produits du rayon X")
    public void jeRecupereTousLesProduitsDuRayonX() {
        produitsBDD = ProduitDAO.tousLesProduits(X);
    }

    @Then("La liste recuperee est composee des produits du rayon X")
    public void laListeRecupereeEstComposeeDesProduitsDuRayonX() {
        for (Produit p: produitsRayonX) {
            boolean present = false;
            for (Produit pBdd: produitsBDD) {
                if (p.getIdProduit() == pBdd.getIdProduit()){
                    present = true;
                    break;
                }
            }
            if(!present){ fail(); }
        }
    }

    List<Rayon> rayons = new ArrayList<>();

    @Given("J'ajoute deux rayons X et Y a la base de donnees")
    public void jAjouteDeuxRayonsXEtYALaBaseDeDonnees() {
        X = new Rayon("X",null, new ArrayList<>(),null);
        Y = new Rayon("Y",null, new ArrayList<>(),null);

        rayons.add(X);
        rayons.add(Y);

        EntityManager em = Connexion.getEntityManager();
        em.getTransaction().begin();
        em.persist(X);
        em.persist(Y);
        em.getTransaction().commit();
        em.close();
    }

    List<Rayon> rayonsBDD = new ArrayList<>();

    @When("Je recupere tous les rayons")
    public void jeRecupereTousLesRayons() {
        rayonsBDD = RayonDAO.tousLesRayons();
    }

    @Then("La liste recuperee possede les deux memes rayons")
    public void laListeRecupereePossedeLesDeuxMemesRayons() {
        for(Rayon r : rayons){
            boolean present = false;
            for(Rayon rbdd : rayonsBDD){
                if (rbdd.getIdRayon() == r.getIdRayon()) {
                    present = true;
                    break;
                }
            }
            if(!present){ fail(); }
        }
    }

    Rayon rayonBDD;

    @When("Je cherche le rayon X a partir de son id")
    public void jeChercheLeRayonXAPartirDeSonId() {
        rayonBDD = RayonDAO.trouverRayon(X.getIdRayon());
    }

    @Then("Le rayon recupere est X")
    public void leRayonRecupereEstX() {
        assertEquals(rayonBDD.getIdRayon(), X.getIdRayon());
    }

}