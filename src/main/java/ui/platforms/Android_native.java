package ui.platforms;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.Config;
import ui.Platform;
import ui.enums.Platforms;

public class Android_native implements Platform {

    private AppiumDriver driver = new AndroidDriver(Config.getAppiumUrl(), getCapabilities());

    @Override
    public AppiumDriver getDriver() {
        return driver;
    }

    @Override
    public Platforms checkPlatform() {
        return Platforms.ANDROID_NATIVE;
    }

    @Override
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities Capabilities = new DesiredCapabilities();
        Capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
        Capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, Config.getAppiumVersion());
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Config.getPlatformVersion());
        Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Config.getDeviceName());
        Capabilities.setCapability("appPackage", Config.getAndroidAppPackage());
        Capabilities.setCapability("appActivity", Config.getAndroidAppMainActivity());
        Capabilities.setCapability(MobileCapabilityType.APP, Config.getAndroidAppPathLocal());
        return Capabilities;
    }
}
