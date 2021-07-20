package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import enums.Platforms;

public interface Platform {

  AppiumDriver getDriver();

  DesiredCapabilities getCapabilities();

  Platforms checkPlatform();
}
