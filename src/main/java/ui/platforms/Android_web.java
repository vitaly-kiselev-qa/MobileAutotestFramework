package ui.platforms;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.Config;
import ui.Platform;

public class Android_web implements Platform {

    // Создает уникальный для платформы драйвер
    private AppiumDriver driver = new AppiumDriver(Config.getAppiumUrl(), getCapabilities());

    // Геттер драйвера платформы
    @Override
    public AppiumDriver getDriver() {
        return driver;
    }

    @Override
    public Config.Platforms checkPlatform() {
        return Config.Platforms.ANDROID_WEB;
    }

    // Геттер уникального для платформы набора Capabilities
    @Override
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities Capabilities = new DesiredCapabilities();
        Capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
        Capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, Config.getAppiumVersion());
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Config.getPlatformVersion());
        Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Config.getDeviceName());
        Capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        return Capabilities;
    }



}
