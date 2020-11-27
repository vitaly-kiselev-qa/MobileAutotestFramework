package steps;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import ui.actions.Common;
import ui.Container;
import io.qameta.allure.selenide.AllureSelenide;

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
      Common.timeOut(5);

   }

   @After
   public void tearDown() {
      Common.timeOut(5);
      Container.getInstance().getPlatform().getDriver().quit();
   }

}