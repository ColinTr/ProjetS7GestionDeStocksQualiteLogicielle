package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class produitSteps {
    @Given("^j'ai (\\d+) articles dans mon stock d'articles$")
    public void jAiPommesDansMonStockDePommes(int arg0) {
    }

    @Given("^(\\d+) sont réservés$")
    public void sontRéservés(int arg0) {
    }

    @When("^j'essaie d'en enlever (\\d+)$")
    public void jEssaieDEnEnlever(int arg0) {
    }

    @Then("^c'est possible$")
    public void cEstPossible() {
    }

    @And("^il en reste (\\d+)$")
    public void ilEnReste(int arg0) {
    }

    @Then("^c'est impossible$")
    public void cEstImpossible() {
    }

    @When("^j'essaie d'en réserver (\\d+)$")
    public void jEssaieDEnRéserver(int arg0) {
    }
}
