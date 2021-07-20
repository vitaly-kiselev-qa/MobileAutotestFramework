package pages.locators;

import objects.Locator;
import pages.Page;

public class PageObject_webApp implements Page {

  Locator[] locators = {};

  @Override
  public Locator[] getLocators() {
    return locators;
  }
}
