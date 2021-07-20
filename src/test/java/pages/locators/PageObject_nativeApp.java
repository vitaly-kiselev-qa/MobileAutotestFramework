package pages.locators;

import objects.Locator;
import pages.Page;
import setup.Config;

// Класс ui.Page Object паттерна, где находятся локаторы всех элементов экрана
public class PageObject_nativeApp implements Page {

  Locator[] locators = {
    new Locator(
        "Header",
        String.format("//*[@resource-id='%s:id/primaryTextView']", Config.getAndroidAppPackage()),
        "",
        ""),
    new Locator(
        "Sub header",
        String.format("//*[@resource-id='%s:id/secondaryTextView']", Config.getAndroidAppPackage()),
        "",
        ""),
    new Locator(
        "Add lang btn",
        String.format("//*[@resource-id='%s:id/addLangContainer']", Config.getAndroidAppPackage()),
        "",
        ""),
  };

  @Override
  public Locator[] getLocators() {
    return locators;
  }
}
