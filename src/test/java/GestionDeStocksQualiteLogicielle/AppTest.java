package GestionDeStocksQualiteLogicielle;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @When("^Je suis sur la page d'authentification$")
    public void je_suis_sur_la_page_d_authentification() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("je vais sur la page");
    }

    @Then("^Je vois le bouton \"([^\"]*)\"$")
    public void je_vois_le_bouton(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("je vois l'élément");
    }

}
