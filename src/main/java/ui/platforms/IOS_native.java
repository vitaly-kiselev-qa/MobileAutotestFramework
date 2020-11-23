package ui.platforms;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.Config;
import ui.Platform;

public class IOS_native implements Platform {

    // Создает уникальный для платформы драйвер
    private AppiumDriver driver = new IOSDriver(Config.getAppiumUrl(), getCapabilities());

    // Геттер драйвера платформы
    @Override
    public AppiumDriver getDriver() {
        return driver;
    }

    // Геттер уникального для платформы набора Capabilities
    // TODO: Написать Capabilities под IOS
    @Override
    public Config.Platforms checkPlatform() {
        return Config.Platforms.IOS_NATIVE;
    }

    @Override
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities Capabilities = new DesiredCapabilities();
        /*Capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "...");
        Capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, getAppiumVersion());
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);*/

        return Capabilities;
    }

}
