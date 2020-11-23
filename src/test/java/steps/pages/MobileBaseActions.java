package steps.pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
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
      container.getPlatform().setContextByIndex(0);
   }

   @After
   public void stopApp() {

      Container container = Container.getInstance();
      container.getPlatform().timeOut(5);
      container.getPlatform().quitDriver();
   }

   @Then("Try to swipe")
   public void swipeScreen() {

      container.getPlatform().swipeScreen(Platform.Direction.LEFT);
   }
}