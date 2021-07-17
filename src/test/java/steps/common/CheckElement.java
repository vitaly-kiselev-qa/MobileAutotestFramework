package steps.common;

import com.codeborne.selenide.Condition;
import objects.Element;

public class CheckElement {

    public static void check(String variant, Element element, String text) {

        if (variant.contains("not")) {
            if (text != null && !text.equals("")) {
                element.getSelenideElement().shouldNotBe(Condition.text(text));
            }
        } else {
            element.getSelenideElement().shouldBe(Condition.exist);
            if (text != null && !text.equals("")) {
                element.getSelenideElement().shouldBe(Condition.text(text));
            }
        }
    }

}
