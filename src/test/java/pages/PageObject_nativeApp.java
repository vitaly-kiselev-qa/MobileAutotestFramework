package pages;

import pages.setup.Element;
import pages.setup.Page;

// Класс ui.Page Object паттерна, где находятся локаторы всех элементов экрана
public class PageObject_nativeApp implements Page{

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


