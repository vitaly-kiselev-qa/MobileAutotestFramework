package steps.actions;

import io.cucumber.java.en.When;
import java.util.concurrent.TimeUnit;

public class Timeout {

    @When("Wait {int}")
    public void waitIsSec(int sec) {
        blindTimeOut(sec);
    }

    // Слепой таймаут
    public static void blindTimeOut (int sec){
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
