package steps.pages.PageExample_web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import steps.pages.PageExample_native.PageElements;

public class PageActions {

    @Given("Open url {string}")
    public void openUrl(String url)  throws Throwable {
        PageElements.button_one.click();
    }

}
