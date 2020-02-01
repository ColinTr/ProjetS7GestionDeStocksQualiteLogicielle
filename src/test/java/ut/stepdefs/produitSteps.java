package ut.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modele.Produit;
import modele.Rayon;
import org.mockito.Mockito;

import static org.junit.Assert.*;

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
        assertTrue(resultat);
    }

    @And("^il en reste (\\d+)$")
    public void ilEnReste(int arg0) {
        assertEquals(arg0, produit.getStock());
    }

    @Then("^c'est impossible$")
    public void cEstImpossible() {
        assertFalse(resultat);
    }

    @When("^j'essaie d'en réserver (\\d+)$")
    public void jEssaieDEnRéserver(int arg0) {
        resultat = produit.reservation(arg0);
    }

    int id;
    String nomProduit;
    int stock;
    int reservation;
    float prix;
    Rayon rayon;
    String description;
    String reference;

    @Given("Un produit avec des parametres definis")
    public void unProduitAvecDesParametresDefinis() {
        nomProduit = "Tomate";
        stock = 10;
        reservation = 5;
        prix = (float) 9.99;
        rayon = Mockito.mock(Rayon.class);
        description = "Une tomate bien rouge";
        reference = "AZER987";

        produit = new Produit(nomProduit,stock,reservation,prix,rayon,description,reference);

        id = produit.getIdProduit(); //ici set par hibernate et non par le constructeur
    }

    @Then("les informations recuperees par les getters du produit correspondent")
    public void lesInformationsRecupereesParLesGettersCorrespondent() {
        assertEquals(produit.getIdProduit(), id);
        assertEquals(produit.getNomProduit(), nomProduit);
        assertEquals(produit.getStock(), stock);
        assertEquals(produit.getReservations(), reservation);
        assertEquals(produit.getPrix(), prix, 0.001);
        assertEquals(produit.getRayon(), rayon);
        assertEquals(produit.getDescription(), description);
        assertEquals(produit.getReference(), reference);
    }

    @Given("Un produit par defaut")
    public void unProduitParDefaut() {
        produit = new Produit();
    }

    @When("On change ses attributs par les nouveaux")
    public void onChangeSesAttributsParLesNouveaux() {
        id = 440;
        nomProduit = "Poivron jaune";
        stock = 5;
        reservation = 3;
        prix = (float) 5.3;
        rayon = Mockito.mock(Rayon.class);
        description = "Un poivron bien jaune";
        reference = "QSDF123";

        produit.setIdProduit(id);
        produit.setNomProduit(nomProduit);
        produit.setStock(stock);
        produit.setReservations(reservation);
        produit.setPrix(prix);
        produit.setRayon(rayon);
        produit.setDescription(description);
        produit.setReference(reference);
    }

    Produit produitCopie;

    @When("On fait une copie de ce produit")
    public void onFaitUneCopieDeCeProduit() {
        produitCopie = new Produit(produit.getNomProduit(), produit.getStock(), produit.getReservations(), produit.getPrix(), produit.getRayon(), produit.getDescription(), produit.getReference());
        produitCopie.setIdProduit(produit.getIdProduit());
    }

    @Then("Le hashcode est le meme et le equals fonctionne")
    public void leHashcodeEstLeMemeEtLeEqualsFonctionne() {
        assertEquals(produitCopie.hashCode(), produit.hashCode());
        assertEquals(produit, produit);
        assertEquals(produitCopie, produit);
        assertNotEquals(produit, Mockito.mock(Rayon.class));
        assertNotEquals(produit, new Produit());
    }
}