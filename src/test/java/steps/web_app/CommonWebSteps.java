package steps.web_app;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import ui.Container;
import ui.actions.Common;
import ui.actions.Locators;

public class CommonWebSteps {

    @Given("Open url {string}")
    public void openUrl(String url) {
        Container.getInstance().getPlatform().getDriver().get(url);
    }



}
