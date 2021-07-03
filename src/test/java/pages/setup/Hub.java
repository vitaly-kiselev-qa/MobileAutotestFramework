package pages.setup;

import pages.PageObject_nativeApp;

public class Hub {

    public static Element[] getPageElements(String pageName) {
        switch (pageName) {
            case "page one": return new PageObject_nativeApp().getElements();
            case "page two": return new PageObject_nativeApp().getElements();
            case "page three": return new PageObject_nativeApp().getElements();
            case "page four": return new PageObject_nativeApp().getElements();
            default: return new PageObject_nativeApp().getElements();
        }
    }

}
