package setup.platforms;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import setup.Config;
import setup.Platform;
import enums.Platforms;

public class Android_web implements Platform {

    private AppiumDriver driver = new AndroidDriver(Config.getAppiumUrl(), getCapabilities());

    @Override
    public AppiumDriver getDriver() {
        return driver;
    }

    @Override
    public Platforms checkPlatform() {
        return Platforms.ANDROID_WEB;
    }

    @Override
    public DesiredCapabilities getCapabilities() {

        setWebDriverVersion(); // Костыль, чтобы явно указать необходимую версию Chromedriver

        DesiredCapabilities Capabilities = new DesiredCapabilities();
        Capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
        Capabilities.setCapability("appiumVersion", Config.getAppiumVersion());
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Config.getPlatformVersion());
        Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Config.getDeviceName());
        Capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, Config.getWebBrowserName());
        Capabilities.setCapability("chromedriverExecutable",WebDriverManager.chromedriver().getDownloadedDriverPath());
        return Capabilities;
    }

    private void setWebDriverVersion() {
        // Костыль, чтобы подстроить ChromeDriver под мобильный Chrome
        WebDriverManager.chromedriver().browserVersion(Config.getWebBrowserVersion()).setup();
        System.out.print("POINT: Chromedriver path: " + WebDriverManager.chromedriver().getDownloadedDriverPath() + "\n");

        // Скачивает необходимую версию драйвера нужного браузера
        switch (Config.getWebBrowserName().toLowerCase()) {
            case "chrome": WebDriverManager.chromedriver().browserVersion(Config.getWebBrowserVersion()).setup(); break;
            case "ff": WebDriverManager.firefoxdriver().browserVersion(Config.getWebBrowserVersion()).setup(); break;
            case "edge": WebDriverManager.edgedriver().browserVersion(Config.getWebBrowserVersion()).setup(); break;
        }
    }
}
