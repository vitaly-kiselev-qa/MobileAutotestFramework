package steps;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import ui.Actions;
import ui.Container;
import io.qameta.allure.selenide.AllureSelenide;

/*
Класс с основными методами взаимодействия с приложением, не зависящими от конкретных элементов ui.Page
Предлагаю не наполнять его новыми методами, или добавлять только "базовые" методы, подготавливающие приложение к тестированию.
Методы для конкретных экранов должны быть реализованны отдельно в классах, логически связанных с ui.Page
TODO: Написать методы работы с активити типа Restart the app
 */

public class Setup {

   @Before
   public void setUp() {

      // Добавляет скриншоты и DOM source в attachments к шагам при фейле тестов
      SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

      /* Как прикрепить скрин принудительно:
      Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot)
      Container.getInstance().getPlatform().getDriver()).getScreenshotAs(OutputType.BYTES)));
       */

      // Запускает выбранную в Config платформу
      Container.getInstance().runPlatform();

      // Слепой таймаут чтобы законтрить splashscreen
      // TODO: Сделать так, чтобы метод понимал, когда кончился Splash-screen перед прохождением др. шагов
      Actions.timeOut(5);

   }

   @After
   public void tearDown() {
      Actions.timeOut(5);
      Container.getInstance().quitPlatform();
   }

}