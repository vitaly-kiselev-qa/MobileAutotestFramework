package ui;

import ui.enums.Platforms;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class Config {

    // Common area
    final private static String PLATFORM_NAME = "Android_native"; // ANDROID_NATIVE, IOS_NATIVE, ANDROID_WEB, IOS_WEB
    final private static String DEVICE_NAME = "Device"; // Random for everyone, exclude IOS
    final private static String PLATFORM_VERSION = "10.0"; // Current device OS version

    // Appium area
    final private static String APPIUM_VERSION = "1.18.3"; // See Appium server version
    final private static String APPIUM_URL = "http://127.0.0.1:4723/wd/hub"; // Const, don't touch

    // Web area
    final private static String WEB_BROWSER_NAME = "Chrome"; // Chrome, FF, Edge
    final private static String WEB_BROWSER_VERSION = "86"; // Check installed browser version

    // Android area
    final private static String ANDROID_APP_PACKAGE = "org.wikipedia"; // Android only. See package checker
    final private static String ANDROID_APP_MAIN_ACTIVITY = "org.wikipedia.main.MainActivity"; // Android only. See - package checker
    final private static String ANDROID_APP_PATH_LOCAL = System.getProperty("user.home").concat("/Desktop/wiki.apk");

    public static URL getAppiumUrl() {
        URL appiumServer = null;
        try {
            appiumServer = new URL(APPIUM_URL);
        } catch (MalformedURLException e) {}
        return appiumServer;
    }
    public static String getAppiumVersion() {return APPIUM_VERSION; }
    public static Platforms getCurrentPlatformName() {
        Platforms currentPlatform = null;
        switch (PLATFORM_NAME.toLowerCase()) {
            case "android_native": currentPlatform = Platforms.ANDROID_NATIVE; break;
            case "android_web": currentPlatform = Platforms.ANDROID_WEB; break;
            case "ios_native": currentPlatform = Platforms.IOS_NATIVE; break;
            case "ios_web": currentPlatform = Platforms.IOS_WEB; break;
            default:
                System.out.printf("ERROR: Undefined platform: " + PLATFORM_NAME + "\n");
                break;
        }
        return currentPlatform;
    }
    public static String getPlatformVersion() {
        return PLATFORM_VERSION;
    }
    public static String getDeviceName() {
        return DEVICE_NAME;
    }
    public static String getAndroidAppPackage() {
        return ANDROID_APP_PACKAGE;
    }
    public static String getAndroidAppMainActivity() {
        return ANDROID_APP_MAIN_ACTIVITY;
    }
    public static String getAndroidAppPathLocal() {
        return Paths.get(ANDROID_APP_PATH_LOCAL).toAbsolutePath().toString();
    }
    public static String getWebBrowserName() {
        return WEB_BROWSER_NAME;
    }
    public static String getWebBrowserVersion() {
        return WEB_BROWSER_VERSION;
    }

}
