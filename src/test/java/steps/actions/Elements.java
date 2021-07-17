package steps.actions;

import io.cucumber.java.en.When;
import pages.setup.Selectors;

import static steps.app.Context.setContextByName;

//TODO: Написать методы работы с активити типа Restart the app

public class Elements {

    @When("Click element by text {string} in context {string}")
    public void clickElementByTextInContext(String system, String context) {
        setContextByName("NATIVE_APP");
        Selectors.getXpathByText(system).click();
    }



}
