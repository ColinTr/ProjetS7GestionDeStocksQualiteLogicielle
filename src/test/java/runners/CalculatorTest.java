package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/ressources",
        glue="stepdefs",
        plugin = {"pretty", "html:target/cucumber-html-report"} )
public class CalculatorTest {
    //Cette classe est vide.
}
