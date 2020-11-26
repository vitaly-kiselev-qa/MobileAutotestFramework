package steps;

import io.cucumber.java.en.Then;
import ui.Actions;

public class Common {

    @Then("Swipe {string}")
    public void swipeScreen(String string) {
        switch (string.toLowerCase()) {
            case "left": Actions.swipeScreen(Actions.Direction.LEFT); break;
            case "right": Actions.swipeScreen(Actions.Direction.RIGHT); break;
            case "up": Actions.swipeScreen(Actions.Direction.UP); break;
            case "down": Actions.swipeScreen(Actions.Direction.DOWN); break;
            default: System.out.print("ERROR: unknown direction");
        }
    }
}
