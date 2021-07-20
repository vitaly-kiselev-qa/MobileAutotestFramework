package steps;

import io.cucumber.java.en.When;
import pages.Selectors;

import static steps.app_actions.Context.setContextByName;

//TODO: переделать

public class old_context {

    @When("Click element by text {string} in context {string}")
    public void clickElementByTextInContext(String system, String context) {
        setContextByName("NATIVE_APP");
        Selectors.getXpathByText(system).click();
    }
}
