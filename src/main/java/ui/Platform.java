package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.enums.Platforms;

public interface Platform {

    AppiumDriver getDriver();
    DesiredCapabilities getCapabilities();
    Platforms checkPlatform();
}
