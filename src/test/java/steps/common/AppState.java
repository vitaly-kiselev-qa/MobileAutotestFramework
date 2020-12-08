package steps.common;

import io.cucumber.java.en.Given;
import ui.PlatformHolder;


public class AppState {

    @Given("Start the app")
    public void startApp() {
        PlatformHolder.getInstance().runPlatform();
    }

    @Given("Stop the app")
    public void stopApp() {
        PlatformHolder.getInstance().getPlatform().getDriver().quit();
    }

}
