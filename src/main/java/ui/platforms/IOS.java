package ui.platforms;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.Config;
import ui.Platform;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.$x;

public class IOS implements Platform {

    // Создает уникальный для платформы драйвер
    private AppiumDriver driver = new IOSDriver(Config.getAppiumUrl(), getCapabilities());

    // Геттер драйвера платформы
    public AppiumDriver getDriver() {
        return driver;
    }

    // Геттер уникального для платформы набора Capabilities
    // TODO: Написать Capabilities под IOS
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities Capabilities = new DesiredCapabilities();
        /*
        Capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "...");
        Capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, getAppiumVersion());
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        */

        return Capabilities;
    }
}