package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Cette classe permet d'effectuer tous les tests au sein du dossier stepdefs
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/ressources",
        glue="stepdefs",
        plugin = {"pretty", "html:target/cucumber-html-report"} )
public class monRunner {
    //Cette classe est vide.
}