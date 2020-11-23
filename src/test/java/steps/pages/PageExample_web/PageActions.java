package steps.pages.PageExample_web;

import io.cucumber.java.en.When;
import steps.pages.PageExample_native.PageElements;

public class PageActions {

    @When("Try to open url")
    public void pushTheBtnOne()  throws Throwable {
        PageElements.button_one.click();
    }

}
