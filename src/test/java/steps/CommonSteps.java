package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.actions.Common;
import ui.actions.Locators;
import ui.enums.Directions;

//TODO: Написать методы работы с активити типа Restart the app

public class CommonSteps {

    @When("Simple swipe {string}")
    public void swipeScreen(String string) {
        switch (string.toLowerCase()) {
            case "left": ui.actions.Common.swipeScreen(Directions.LEFT); break;
            case "right": ui.actions.Common.swipeScreen(Directions.RIGHT); break;
            case "up": ui.actions.Common.swipeScreen(Directions.UP); break;
            case "down": ui.actions.Common.swipeScreen(Directions.DOWN); break;
            default: System.out.print("ERROR: unknown direction");
        }
    }

    @When("Switch context to {string}")
    public void switchContextTo(String context) {
        Common.setContextByName(context.toUpperCase());
    }

    @When("Click element by text {string} in context {string}")
    public void clickElementByTextInContext(String system, String context) {
        Common.setContextByName("NATIVE_APP");
        Locators.getLocatorByText(system).click();
    }

    @When("Skip dialog window {string}")
    public void SkipDialogWindow(String window_name) {

        switch (window_name.toLowerCase()) {
            case "choose search system":
                Common.setContextByIndex(0);
                Locators.getLocatorByText("Google").click();
                Locators.getLocatorByResourceId("com.android.chrome", "button_primary").click();
                Common.setContextByIndex(1);
                break;
            default:
                System.out.print("ERROR: Unknown window: " + window_name);
        }


    }

}
