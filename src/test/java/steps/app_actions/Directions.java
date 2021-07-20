package steps.app_actions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import setup.PlatformHolder;
import java.time.Duration;

public class Directions {

    @When("Simple swipe {string}")
    public void swipeScreen(String string) {
        switch (string.toLowerCase()) {
            case "left": swipeScreen(enums.Directions.LEFT, 300, 500); break;
            case "right": swipeScreen(enums.Directions.RIGHT, 300, 500); break;
            case "up": swipeScreen(enums.Directions.UP, 300, 500); break;
            case "down": swipeScreen(enums.Directions.DOWN,300,500); break;
            default: System.out.print("ERROR: unknown direction");
        }
    }

    private static void swipeScreen(enums.Directions dir, int animation_time, int press_time) {
        PlatformHolder platformHolder = PlatformHolder.getInstance();
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // Логирование событий в консоль

        final int ANIMATION_TIME = animation_time;
        final int PRESS_TIME = press_time;
        int edgeBorder = 10;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = platformHolder.getPlatform().getDriver().manage().window().getSize();

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
            new TouchAction<>(platformHolder.getPlatform().getDriver())
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
}
