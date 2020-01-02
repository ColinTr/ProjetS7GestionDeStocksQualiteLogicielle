package ut.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Cette classe permet d'effectuer tous les tests au sein du dossier ut.stepdefs
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        strict=false,
        features= "src/test/resources/ut",
        glue= "ut/stepdefs",
        tags = {"not @done"}, //"not @done"
        plugin = {"html:target/cucumber-html-report"} )
public class monRunnerTest {
    //Cette classe est vide.
}