package pages;

import com.codeborne.selenide.SelenideElement;
import pages.setup.Element;
import pages.setup.Page;

import static com.codeborne.selenide.Selenide.$x;

public class PageObject_webApp implements Page {

    Element[] elements = {
            Element.create("1","",""),
            Element.create("1","",""),
            Element.create("1","",""),
            Element.create("1","",""),
            Element.create("1","",""),
            Element.create("1","",""),
            Element.create("1","",""),
    };

    @Override
    public Element[] getElements() {
        return elements;
    }
}
