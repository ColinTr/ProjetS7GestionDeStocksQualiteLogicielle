package ut.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modele.Magasin;
import modele.Rayon;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;


public class magasinSteps {

    Magasin magasin;

    @Given("J'ai un magasin")
    public void jAiUnMagasin() {
        magasin = new Magasin();
    }

    Rayon rayon;

    @When("J'ajoute un rayon à ce magasin")
    public void jAjouteUnRayonÀCeMagasin() {
        rayon = Mockito.mock(Rayon.class);
        magasin.ajouterRayon(rayon);
    }

    @Then("Ce rayon est dans la liste de ce magasin")
    public void ceRayonEstDansLaListeDeCeMagasin() {
        assertEquals(magasin.getListeRayons().get(0), rayon);
    }
}
