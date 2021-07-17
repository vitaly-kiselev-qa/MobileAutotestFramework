package pages;

import objects.Locator;
import pages.setup.Page;

public class PageObject_webApp implements Page {

    Locator[] locators = {
    };

    @Override
    public Locator[] getLocators() {
        return locators;
    }
}
