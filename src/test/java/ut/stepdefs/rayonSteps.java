package ut.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modele.Magasin;
import modele.Produit;
import modele.Rayon;
import modele.Utilisateur;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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

    int idRayon;
    String nomRayon = "rayon";
    Utilisateur chefDeRayon = Mockito.mock(Utilisateur.class);
    List<Produit> listeProduits = new ArrayList<>();
    Magasin magasin = Mockito.mock(Magasin.class);


    @Given("Un rayon avec des parametres definis")
    public void unRayonAvecDesParametresDefinis() {
        rayon = new Rayon(nomRayon, chefDeRayon,listeProduits,magasin);

        idRayon = rayon.getIdRayon(); // Générer par hibernate
    }

    @Then("les informations recuperees par les getters du rayon correspondent")
    public void lesInformationsRecupereesParLesGettersDuRayonCorrespondent() {
        assertEquals(rayon.getIdRayon(), idRayon);
        assertEquals(rayon.getNomRayon(), nomRayon);
        assertEquals(rayon.getChefDeRayon(), chefDeRayon);
        assertEquals(rayon.getListeProduits(), listeProduits);
        assertEquals(rayon.getMagasin(), magasin);
        assertEquals(rayon.getNbProduits(), listeProduits.size());
    }

    @Given("Un rayon par defaut")
    public void unRayonParDefaut() {
        rayon = new Rayon();
    }

    @When("On change les attributs du rayon par les nouveaux")
    public void onChangeLesAttributsDuRayonParLesNouveaux() {
        idRayon = 45;

        rayon.setIdRayon(idRayon);
        rayon.setNomRayon(nomRayon);
        rayon.setChefDeRayon(chefDeRayon);
        rayon.setListeProduits(listeProduits);
        rayon.setMagasin(magasin);
    }
}
