package steps.web_app_page_example;

import io.cucumber.java.en.Given;
import ui.PlatformHolder;

public class CommonWebSteps {

    @Given("Open url {string}")
    public void openUrl(String url) {
        PlatformHolder.getInstance().getPlatform().getDriver().get(url);
    }



}
