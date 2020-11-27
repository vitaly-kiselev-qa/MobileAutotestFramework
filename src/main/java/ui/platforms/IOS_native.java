package ui.platforms;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.Config;
import ui.Platform;
import ui.enums.Platforms;

public class IOS_native implements Platform {

    private AppiumDriver driver = new IOSDriver(Config.getAppiumUrl(), getCapabilities());

    @Override
    public AppiumDriver getDriver() {
        return driver;
    }

    // TODO: Написать Capabilities под IOS
    @Override
    public Platforms checkPlatform() {
        return Platforms.IOS_NATIVE;
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
