package steps;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import setup.PlatformHolder;

public class Hooks {

   @Before
   public void beforeScenario() {
      // Добавляет скриншоты и DOM source в attachments к шагам при фейле тестов
      SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
   }

   @After
   public void afterScenario() { }

   @BeforeClass
   public void setUp() {
      PlatformHolder.getInstance().runPlatform();
   }

   @AfterClass
   public void tearDown() {
      PlatformHolder.getInstance().getPlatform().getDriver().quit();
   }

}