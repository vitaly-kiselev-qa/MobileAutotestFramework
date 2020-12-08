package steps.common;


import io.cucumber.java.en.When;
import ui.actions.Locators;

import static steps.common.Context.setContextByName;

//TODO: Написать методы работы с активити типа Restart the app

public class Elements {

    @When("Click element by text {string} in context {string}")
    public void clickElementByTextInContext(String system, String context) {
        setContextByName("NATIVE_APP");
        Locators.getLocatorByText(system).click();
    }



}
