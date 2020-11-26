package ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/*
Интерфейс для страниц PageObject
Описывает логику выбора локатора под необходимую платформу из массива локаторов для конкретного элемента
 */

public interface Page {

    // Отдает индекс используемой в конфиге платформы
    static int switchLocator() {
        int platformIndex = 0;
        switch (Config.getCurrentPlatformName()) {
            case ANDROID_NATIVE: platformIndex = 0; break;
            case IOS_NATIVE: platformIndex = 1; break;
            default: System.out.print("ERROR: Undefined platform. Android set as default platform"); break;
        }
        return platformIndex;
    }

    // Записывает локаторы для всех платформ в массив и отдает нужный по индексу платформы
    static SelenideElement setLocatorsForNativeApps(SelenideElement android, SelenideElement ios){
        SelenideElement[] array = {android, ios};
        return array[Page.switchLocator()];
    }

    // Метод для Android, который ищет элемент по id. Package получает из конфига
    static SelenideElement getLocatorByResourceId(String id) {
        return $x(String.format("//*[@resource-id='%s:id/%s']", Config.getAndroidAppPackage(), id));
    }
}
