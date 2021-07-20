package pages;

import objects.Locator;
import pages.locators.PageObject_nativeApp;

public class Hub {

  // Общий метод, отдающий нужный PageObject по уникальному ключу
  public static Locator[] getPageElements(String pageName) {
    switch (pageName) {
      case "Start page":
        return new PageObject_nativeApp().getLocators();
      default:
        throw new Error("Can't find the page: " + pageName);
    }
  }
}
