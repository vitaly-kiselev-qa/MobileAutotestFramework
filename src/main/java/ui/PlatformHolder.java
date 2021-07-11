package ui;

import com.codeborne.selenide.WebDriverRunner;
import ui.platforms.Android_native;
import ui.platforms.Android_web;
import ui.platforms.IOS_native;

import java.util.concurrent.TimeUnit;

/*
Контейнер, где будет хранится экземпляр одного из классов платформ  ui.platforms.*
Нужен для того, чтобы одни и те же тесты могли вызывать разные драйверы разных классов
(Тесты не знают, какой драйвер записан в контейнер)
 */

public class PlatformHolder {
    private Platform platform;

    // Singleton
    private static PlatformHolder instance;
    private PlatformHolder(){}
    public static PlatformHolder getInstance(){
        if(instance == null){
            instance = new PlatformHolder();
        }
        return instance;
    }

    private void setPlatform(){
        switch (Config.getCurrentPlatformName()) {
            case ANDROID_NATIVE: platform = new Android_native(); break;
            case ANDROID_WEB: platform = new Android_web(); break;
            case IOS_NATIVE: platform = new IOS_native(); break;
            case IOS_WEB: //platform = new IOS_web(); break;
            default: throw new Error("Unknown platform!");
        }
        System.out.print("POINT: Container.setPlatform: " + platform.checkPlatform() + "\n");
    }

    public void runPlatform() {
        setPlatform();
        WebDriverRunner.setWebDriver(platform.getDriver());
        platform.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.print("POINT: Container.runPlatform: " + platform.checkPlatform() + "\n");
    }

    public Platform getPlatform(){
        return platform;
    }
}
