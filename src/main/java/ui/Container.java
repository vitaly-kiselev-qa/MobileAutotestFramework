package ui;

import ui.platforms.Android_native;
import ui.platforms.Android_web;
import ui.platforms.IOS_native;

public class Container {
    private Platform platform;

    //Singleton
    private static Container instance;
    private Container(){}
    public static Container getInstance(){
        if(instance == null){
            instance = new Container();
        }
        return instance;
    }

    // Инициализирует платформу контейнера нужной платформой, ссылаясь на переменную в config
    private void setPlatform(){
        switch (Config.getCurrentPlatformName()) {
            case ANDROID_NATIVE: platform = new Android_native(); break;
            case ANDROID_WEB: platform = new Android_web(); break;
            case IOS_NATIVE: platform = new IOS_native(); break;
            case IOS_WEB: //platform = new IOS_web(); break;
            default: System.out.print("ERROR: UNKNOWN PLATFORM"); break;
        }
        System.out.print("POINT: Container.setPlatform: " + platform.checkPlatform() + "\n");
    }

    // Отдает инициализированную контейнером платформу
    public Platform getPlatform(){
        return platform;
    }

    // Запускает инициализированную контейнером платформу
    public void runPlatform() {
        setPlatform();
        platform.runDriver();
        System.out.print("POINT: Container.runPlatform: " + platform.checkPlatform() + "\n");
    }
}
