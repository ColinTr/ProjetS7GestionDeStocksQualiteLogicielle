package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class utilisateurSteps {

    @Given("^a$")
    public void a() {
    }

    @When("^b$")
    public void b() {
    }

    @Then("^c$")
    public void c() {
    }

    @Given("^j'ai entre ce nom de compte <nomDeCompteATester>$")
    public void jAiEntreCeNomDeCompteNomDeCompteATester() {
    }

    @When("^je test <nomDeCompteATester> pour voir s'il est acceptable$")
    public void jeTestNomDeCompteATesterPourVoirSIlEstAcceptable() {
    }

    @Then("^le resultat devrait etre <valeurRetour> pour <nomDeCompteATester>$")
    public void leResultatDevraitEtreValeurRetourPourNomDeCompteATester() {
    }

    @Given("^j'ai entre ce mot de passe <motDePasseATester>$")
    public void jAiEntreCeMotDePasseMotDePasseATester() {
    }

    @When("^je test <motDePasseATester> pour voir s'il est acceptable$")
    public void jeTestMotDePasseATesterPourVoirSIlEstAcceptable() {
    }


    @Then("^le resultat devrait etre <valeurRetour> pour <motDePasseATester>$")
    public void leResultatDevraitEtreValeurRetourPourMotDePasseATester() {
    }

}