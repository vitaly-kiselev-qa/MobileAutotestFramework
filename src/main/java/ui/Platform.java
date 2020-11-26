package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface Platform {

    AppiumDriver getDriver();
    DesiredCapabilities getCapabilities();
    Config.Platforms checkPlatform();
}
