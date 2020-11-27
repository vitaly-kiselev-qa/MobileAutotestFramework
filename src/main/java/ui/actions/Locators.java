package ui.actions;

import com.codeborne.selenide.SelenideElement;
import ui.Config;

import static com.codeborne.selenide.Selenide.$x;

public class Locators {

    // Отдает индекс используемой в конфиге платформы
    private static int switchLocator() {
        int platformIndex = 0;
        switch (Config.getCurrentPlatformName()) {
            case ANDROID_NATIVE: platformIndex = 0; break;
            case IOS_NATIVE: platformIndex = 1; break;
            default: System.out.print("ERROR: Undefined platform. Android set as default platform"); break;
        }
        return platformIndex;
    }

    // Записывает локаторы для всех платформ в массив и отдает нужный по индексу платформы
    public static SelenideElement setLocatorsForNativeApps(SelenideElement android, SelenideElement ios){
        SelenideElement[] array = {android, ios};
        return array[Locators.switchLocator()];
    }

    // Метод для Android, который ищет элемент по id. Package получает из конфига
    public static SelenideElement getLocatorByResourceId(String appPackage, String id) {
        return $x(String.format("//*[@resource-id='%s:id/%s']", appPackage, id));
    }
    public static SelenideElement getLocatorByResourceId(String id) {
        return getLocatorByResourceId(Config.getAndroidAppPackage(), id);
    }

    public static SelenideElement getLocatorByText(String text) {
        return $x(String.format("//*[@text='%s']", text));
    }
}
