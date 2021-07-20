package steps.common_actions;

import com.codeborne.selenide.Condition;
import enums.Timeouts;
import objects.Element;

public class ElementActions {

  public static void check(String variant, Element element) {

    if (variant.contains("not")) {
      if (element.getText() != null && !element.getText().equals("")) {
        element.getSelenideElement().shouldNotBe(Condition.text(element.getText()));
      }
    } else {
      element.getSelenideElement().shouldBe(Condition.exist);
      if (element.getText() != null && !element.getText().equals("")) {
        element.getSelenideElement().shouldBe(Condition.text(element.getText()));
      }
    }
  }

  public static void clickElement(Element element) {
    ElementActions.check("", element);
    element.getSelenideElement().click();
    Timeout.blindTimeOut(Timeouts.AFTER_CLICK_TIMEOUT.get());
  }
}
