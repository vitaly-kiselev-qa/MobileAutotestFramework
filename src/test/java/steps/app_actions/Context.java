package steps.app_actions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.When;
import pages.Selectors;
import setup.PlatformHolder;

import java.util.Set;

public class Context {

    @When("Switch context to {string}")
    public void switchContextTo(String context) {
        setContextByName(context.toUpperCase());
    }

    @When("Skip dialog window {string}")
    public void SkipDialogWindow(String window_name) {

        switch (window_name.toLowerCase()) {
            case "choose search system":
                setContextByIndex(0);
                Selectors.getXpathByText("Google").click();
                Selectors.getXpathByResourceId("com.android.chrome", "button_primary").click();
                setContextByIndex(1);
                break;
            default:
                System.out.print("ERROR: Unknown window: " + window_name);
        }
    }

    // Меняет Context по индексу - позволяет перейти с native на webview и обратно
    public static void setContextByIndex(int contextIndex) {
        AppiumDriver driver = PlatformHolder.getInstance().getPlatform().getDriver();
        Set<String> contextNames = driver.getContextHandles();
        int i = 0;
        for (String contextName : contextNames) {
            System.out.printf("CONTEXT ARRAY [%s], object: %s\n", i, contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
            i++;
        }
        driver.context(contextNames.toArray()[contextIndex].toString());
    }
    public static void setContextByName(String context) {

        Set<String> contextNames = PlatformHolder.getInstance().getPlatform().getDriver().getContextHandles();
        int i = 0;
        for (String contextName : contextNames) {
            System.out.printf("CONTEXT ARRAY [%s], object: %s\n", i, contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
            i++;
        }
        PlatformHolder.getInstance().getPlatform().getDriver().context(context.toUpperCase());
    }
}
