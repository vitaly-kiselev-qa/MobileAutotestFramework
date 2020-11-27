package ui.actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import ui.Container;
import ui.enums.Directions;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Common {

    // Меняет Context по индексу - позволяет перейти с native на webview и обратно
    public static void setContextByIndex(int contextIndex) {
        AppiumDriver driver = Container.getInstance().getPlatform().getDriver();
        Set<String> contextNames = driver.getContextHandles();
        int i = 0;
        for (String contextName : contextNames) {
            System.out.printf("CONTEXT ARRAY [%s], object: %s\n", i, contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
            i++;
        }
        driver.context(contextNames.toArray()[contextIndex].toString());
    }
    public static void setContextByName(String context) {

        Set<String> contextNames = Container.getInstance().getPlatform().getDriver().getContextHandles();
        int i = 0;
        for (String contextName : contextNames) {
            System.out.printf("CONTEXT ARRAY [%s], object: %s\n", i, contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
            i++;
        }
        Container.getInstance().getPlatform().getDriver().context(context.toUpperCase());
    }

    // Скроллит экран по заданному Direction
    public static void swipeScreen(Directions dir) {
        Container container = Container.getInstance();
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // Логирование событий в консоль

        final int ANIMATION_TIME = 300;
        final int PRESS_TIME = 500;
        int edgeBorder = 10;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = container.getPlatform().getDriver().manage().window().getSize();

        switch (dir) {
            case DOWN:
                pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP:
                pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT:
                pointOptionStart = PointOption.point(dims.width * 3 / 4, dims.height / 2);
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT:
                pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        try {
            new TouchAction<>(container.getPlatform().getDriver())
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    // Слепой таймаут
    public static void timeOut (int sec){
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
