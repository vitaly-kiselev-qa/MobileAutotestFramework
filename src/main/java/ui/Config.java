package ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public abstract class Config {

    //TODO: Получать значения из конфига мавена
    final private static String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    final private static String APPIUM_VERSION = "1.18.3";
    final private static String PLATFORM_NAME = "Android_native";
    final private static String PLATFORM_VERSION = "10.0";
    final private static String DEVICE_NAME = "Device";
    final private static String ANDROID_APP_PACKAGE = "org.wikipedia";
    final private static String ANDROID_APP_MAIN_ACTIVITY = "org.wikipedia.main.MainActivity";
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
            case "android_native":
                currentPlatform = Platforms.ANDROID_NATIVE;
                System.out.printf("POINT: Config.getCurrentPlatformName: " + Platforms.ANDROID_NATIVE + "\n");
                break;
            case "android_web":
                currentPlatform = Platforms.ANDROID_WEB;
                System.out.printf("POINT: Config.getCurrentPlatformName: " + Platforms.ANDROID_WEB + "\n");
                break;
            case "ios_native":
                currentPlatform = Platforms.IOS_NATIVE;
                System.out.printf("POINT: Config.getCurrentPlatformName: " + Platforms.IOS_NATIVE + "\n");
                break;
            case "ios_web":
                currentPlatform = Platforms.IOS_WEB;
                System.out.printf("POINT: Config.getCurrentPlatformName: " + Platforms.IOS_WEB + "\n");
                break;
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

    public enum Platforms {
        ANDROID_NATIVE, IOS_NATIVE, ANDROID_WEB, IOS_WEB
    }

}
