package pages.setup;

import objects.Locator;
import pages.PageObject_nativeApp;

public class Hub {

    public static Locator[] getPageElements(String pageName) {
        switch (pageName) {
            case "Start page": return new PageObject_nativeApp().getLocators();
            default: throw new Error("Can't find the page: " + pageName);
        }
    }

}
