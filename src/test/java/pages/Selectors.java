package pages;

import com.codeborne.selenide.SelenideElement;
import setup.Config;

import static com.codeborne.selenide.Selenide.$x;

public class Selectors {

  // Метод для Android, который ищет элемент по id. Package получает из конфига
  public static SelenideElement getXpathByResourceId(String appPackage, String id) {
    return $x(String.format("//*[@resource-id='%s:id/%s']", appPackage, id));
  }

  public static SelenideElement getXpathByResourceId(String id) {
    return getXpathByResourceId(Config.getAndroidAppPackage(), id);
  }

  public static SelenideElement getXpathByText(String text) {
    return $x(String.format("//*[@text='%s']", text));
  }
}
