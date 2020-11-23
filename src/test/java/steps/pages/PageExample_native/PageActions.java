package steps.pages.PageExample_native;

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


}
