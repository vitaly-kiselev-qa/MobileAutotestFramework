package pages;

import pages.setup.Locator;
import pages.setup.Page;

// Класс ui.Page Object паттерна, где находятся локаторы всех элементов экрана
public class PageObject_nativeApp implements Page{

    Locator[] locators = {
            new Locator("Header","//*[@resource-id='org.wikipedia:id/primaryTextView']","",""),
            new Locator("Sub header","//*[@resource-id='org.wikipedia:id/secondaryTextView']","",""),
    };

    @Override
    public Locator[] getLocators() {
        return locators;
    }
}


