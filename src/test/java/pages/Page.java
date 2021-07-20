package pages;

import objects.Locator;

// Интерфейс, от которого нужно наследовать все PageObject
public interface Page {

  Locator[] getLocators();

  static String getLocator(Locator[] locators, String key) {
    String locator = "";

    for (int i = 0; i < locators.length; i++) {
      if (locators[i].getKey().equalsIgnoreCase(key.toLowerCase())) {
        locator = locators[i].getAndroidEl();
        break;
      }
    }
    return locator;
  }
}
