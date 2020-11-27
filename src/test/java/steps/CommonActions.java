package steps;

import io.cucumber.java.en.Then;
import ui.enums.Directions;

//TODO: Написать методы работы с активити типа Restart the app

public class CommonActions {

    @Then("Simple swipe {string}")
    public void swipeScreen(String string) {
        switch (string.toLowerCase()) {
            case "left": ui.actions.Common.swipeScreen(Directions.LEFT); break;
            case "right": ui.actions.Common.swipeScreen(Directions.RIGHT); break;
            case "up": ui.actions.Common.swipeScreen(Directions.UP); break;
            case "down": ui.actions.Common.swipeScreen(Directions.DOWN); break;
            default: System.out.print("ERROR: unknown direction");
        }
    }
}
