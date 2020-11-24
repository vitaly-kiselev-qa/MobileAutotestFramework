package steps.pages.PageExample_web;

import io.cucumber.java.en.Given;
import ui.Container;

public class PageActions {

    Container container = Container.getInstance();

    @Given("Open url {string}")
    public void openUrl(String url) {
        container.getPlatform().getDriver().get(url);
    }

}
