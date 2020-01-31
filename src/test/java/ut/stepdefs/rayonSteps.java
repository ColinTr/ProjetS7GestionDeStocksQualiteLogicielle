package ut.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modele.Produit;
import modele.Rayon;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

public class rayonSteps {

    Rayon rayon;

    @Given("J'ai un rayon")
    public void jAiUnRayon() {
        rayon = new Rayon();
    }

    Produit produit;

    @When("J'ajoute un produit au rayon")
    public void jAjouteUnProduitAuRayon() {
        produit = Mockito.mock(Produit.class);
        rayon.ajouterProduit(produit);
    }

    @Then("Ce produit est dans la liste de produit du rayon")
    public void ceProduitEstDansLaListeDeProduitDuRayon() {
        assertEquals(rayon.getListeProduits().get(0), produit);
    }
}
