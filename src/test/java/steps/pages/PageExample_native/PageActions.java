package steps.pages.PageExample_native;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// Класс, где хранятся основные методы экрана или страницы, которые конвертируются в методы Cucumber
public class PageActions {

    @When("Push the button one")
    public void pushTheBtnOne() {
        PageElements.button_one.click();
    }

    @When("Push the field one")
    public void pushTheFieldOne() {
        PageElements.text_field_one.click();
    }

    @When("Send value {string} the field two")
    public void pushTheFieldTwo(String value) {
        PageElements.text_field_one.click();
    }

    // wiki example

    @When("Push the skip btn")
    public void pushTheSkipBtn() {
        PageElements.wiki_skip_btn.click();
    }

    @Then("Feed exists {string}")
    public void checkFeedExist(String string) {

        switch (string.toLowerCase()) {
            case "true":
                PageElements.wiki_feed_container.shouldHave(Condition.exist);
                break;
            case "false":
                PageElements.wiki_feed_container.shouldHave(Condition.not(Condition.exist));
                break;
            default:
                break;
        }

    }

    @Then("Check feed does not exist")
    public void checkFeedDoesNotExist() {
        PageElements.wiki_feed_container.shouldHave(Condition.not(Condition.exist));
    }


}
