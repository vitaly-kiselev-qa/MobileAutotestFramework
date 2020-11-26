package steps.pages;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import ui.Config;
import ui.Container;
import ui.platforms.Platform;
import io.qameta.allure.selenide.AllureSelenide;

/*
Класс с основными методами взаимодействия с приложением, не зависящими от конкретных элементов Page
Предлагаю не наполнять его новыми методами, или добавлять только "базовые" методы, подготавливающие приложение к тестированию.
Методы для конкретных экранов должны быть реализованны отдельно в классах, логически связанных с Page
TODO: Написать методы работы с активити типа Restart the app
 */

public class MainActions {

   Container container = Container.getInstance();

   @Before
   public void startApp() {

      // Добавляет скриншоты и DOM source в attachments к шагам при фейле тестов
      SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

      /* Как прикрепить скрин принудительно:
      Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot)
      Container.getInstance().getPlatform().getDriver()).getScreenshotAs(OutputType.BYTES)));
       */

      // Запускает выбранную в Config платформу
      container.runPlatform();

      // Слепой таймаут чтобы законтрить splashscreen
      // TODO: Сделать так, чтобы метод понимал, когда кончился Splash-screen перед прохождением др. шагов
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