package ut.stepdefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import modele.Utilisateur;

//@DisplayName("UtilisateurTestClass")
public class utilisateurSteps {

    private String nomDeCompte;
    private String motDePasse;

    private boolean resultat;

    @Given("^j'ai entre ce nom de compte \"([^\"]*)\"$")
    public void jAiEntreCeNomDeCompte(String arg0) throws Throwable {
        nomDeCompte = arg0;
    }

    @When("^je teste \"([^\"]*)\" pour voir si c'est un nom de compte acceptable$")
    public void jeTestePourVoirSiCEstUnNomDeCompteAcceptable(String arg0) throws Throwable {
        resultat = Utilisateur.estCeUnNomDeCompteAcceptable(nomDeCompte);
    }

    @Then("^le resultat devrait etre \"([^\"]*)\" pour nomDeCompteATester$")
    public void leResultatDevraitEtrePourNomDeCompteATester(String arg0) throws Throwable {
        assertEquals(Boolean.parseBoolean(arg0), resultat);
    }

    @Given("^j'ai entre ce mot de passe \"([^\"]*)\"$")
    public void jAiEntreCeMotDePasse(String arg0) throws Throwable {
        motDePasse = arg0;
    }

    @When("^je teste \"([^\"]*)\" pour voir si c'est un mot de passe acceptable$")
    public void jeTestePourVoirSiCEstUnMotDePasseAcceptable(String arg0) throws Throwable {
        resultat = Utilisateur.estCeUnMotDePasseAcceptable(motDePasse);
    }

    @Then("^le resultat devrait etre \"([^\"]*)\" pour motDePasseATester$")
    public void leResultatDevraitEtrePourMotDePasseATester(String arg0) throws Throwable {
        assertEquals(Boolean.parseBoolean(arg0), resultat);
    }
}