package ut.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modele.Magasin;
import modele.Rayon;
import modele.Utilisateur;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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

    int idMagasin;
    String nomMagasin = "A";
    Utilisateur chefDeMagasin = Mockito.mock(Utilisateur.class);
    List<Rayon> rayonList = new ArrayList<>();
    List<Utilisateur> employesList = new ArrayList<>();

    @Given("Un magasin avec des parametres definis")
    public void unMagasinAvecDesParametresDefinis() {
        magasin = new Magasin(nomMagasin,chefDeMagasin,rayonList, employesList);

        idMagasin = magasin.getIdMagasin(); // Generer par hibernate ici
    }

    @Then("les informations recuperees par les getters du magasin correspondent")
    public void lesInformationsRecupereesParLesGettersDuMagasinCorrespondent() {
        assertEquals(magasin.getIdMagasin(), idMagasin);
        assertEquals(magasin.getNomMagasin(), nomMagasin);
        assertEquals(magasin.getChefDeMagasin(), chefDeMagasin);
        assertEquals(magasin.getListeRayons(), rayonList);
        assertEquals(magasin.getListeEmployes(), employesList);
    }

    @Given("Un magasin par defaut")
    public void unMagasinParDefaut() {
        magasin =  new Magasin();
    }

    @When("On change les attributs du magasin par les nouveaux")
    public void onChangeLesAttributsDuMagasinParLesNouveaux() {
        idMagasin = 43;
        magasin.setIdMagasin(idMagasin);
        magasin.setNomMagasin(nomMagasin);
        magasin.setChefDeMagasin(chefDeMagasin);
        magasin.setListeRayons(rayonList);
        magasin.setListeEmployes(employesList);
    }
}
