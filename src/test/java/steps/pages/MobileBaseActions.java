package steps.pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import ui.Config;
import ui.platforms.Android_native;
import ui.Container;
import ui.Platform;

/*
Класс с основными методами взаимодействия с приложением, не зависящими от конкретных элементов Page
Предлагаю не наполнять его новыми методами, или добавлять только "базовые" методы, подготавливающие приложение к тестированию.
Методы для конкретных экранов должны быть реализованны отдельно в классах, логически связанных с Page
TODO: Написать методы работы с активити типа Restart the app
 */

public class MobileBaseActions {

   Container container = Container.getInstance();

   @Before
   public void startApp() {

      //TODO: Сделать так, чтобы метод понимал, когда кончился Splash-screen перед прохождением др. шагов

      container.runPlatform();
      container.getPlatform().timeOut(5);

      if (Config.getCurrentPlatformName().equals(Config.Platforms.ANDROID_WEB)) { }

   }

   @After
   public void stopApp() {

      Container container = Container.getInstance();
      container.getPlatform().timeOut(5);
      container.getPlatform().quitDriver();
   }

   @Then("Swipe {string}")
   public void swipeScreen(String string) {

      switch (string.toLowerCase()) {
         case "left": container.getPlatform().swipeScreen(Platform.Direction.LEFT); break;
         case "right": container.getPlatform().swipeScreen(Platform.Direction.RIGHT); break;
         case "up": container.getPlatform().swipeScreen(Platform.Direction.UP); break;
         case "down": container.getPlatform().swipeScreen(Platform.Direction.DOWN); break;
         default: System.out.print("ERROR: unknown direction");
      }
   }
}