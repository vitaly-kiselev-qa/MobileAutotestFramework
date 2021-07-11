package pages;

import pages.setup.Locator;
import pages.setup.Page;

public class PageObject_webApp implements Page {

    Locator[] locators = {
    };

    @Override
    public Locator[] getLocators() {
        return locators;
    }
}
