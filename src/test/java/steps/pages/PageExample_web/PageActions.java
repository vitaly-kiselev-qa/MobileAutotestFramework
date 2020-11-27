package steps.pages.PageExample_web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import ui.Container;
import ui.actions.Common;
import ui.actions.Locators;

public class PageActions {

    Container container = Container.getInstance();

    @Given("Open url {string}")
    public void openUrl(String url) {
        container.getPlatform().getDriver().get(url);
    }

    @When("Click element by text {string} in context {string}")
    public void chooseSearchSystem(String system, String context) {

        switch (context.toLowerCase()) {
            case "NATIVE_APP":
                Common.setContextByIndex(0);
            case "CHROMIUM":
                Common.setContextByIndex(1);
        }
        Locators.getLocatorByText(system).click();
    }

    @When("Skip dialog window")
    public void clickNativeGoogleOk() {
        Common.setContextByIndex(0);
        Locators.getLocatorByText("Google5").click();
        Locators.getLocatorByResourceId("com.android.chrome", "button_primary").click();
        Common.setContextByIndex(1);
    }

}
