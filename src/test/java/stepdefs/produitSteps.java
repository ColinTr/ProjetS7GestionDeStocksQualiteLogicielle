package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modele.Produit;

import static org.junit.Assert.assertEquals;

//@DisplayName("ProduitTestClass")
public class produitSteps {

    Produit produit = new Produit();

    boolean resultat;

    @Given("^j'ai (\\d+) articles dans mon stock d'articles$")
    public void jAiPommesDansMonStockDePommes(int arg0) {
        produit.setStock(arg0);
    }

    @Given("^(\\d+) sont réservés$")
    public void sontRéservés(int arg0) {
        produit.setReservations(arg0);
    }

    @When("^j'essaie d'en enlever (\\d+)$")
    public void jEssaieDEnEnlever(int arg0) {
        resultat = produit.suppression(arg0);
    }

    @When("^j'essaie d'en enlever -(\\d+)$")
    public void jEssaieDEnEnleverNeg(int arg1) { resultat = produit.suppression(-arg1); }

    @When("^j'essaie d'en ajouter (\\d+)$")
    public void jEssaieDEnAjouter(int arg0) {
        resultat = produit.ajout(arg0);
    }

    @When("^j'essaie d'en ajouter -(\\d+)$")
    public void jEssaieDEnAjouterNeg(int arg1) { resultat = produit.ajout(-arg1); }

    @Then("^c'est possible$")
    public void cEstPossible() {
        assertEquals(true, resultat);
    }

    @And("^il en reste (\\d+)$")
    public void ilEnReste(int arg0) {
        assertEquals(arg0, produit.getStock());
    }

    @Then("^c'est impossible$")
    public void cEstImpossible() {
        assertEquals(false, resultat);
    }

    @When("^j'essaie d'en réserver (\\d+)$")
    public void jEssaieDEnRéserver(int arg0) {
        resultat = produit.reservation(arg0);
    }

}