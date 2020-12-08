package steps.common;

import io.cucumber.java.en.When;
import java.util.concurrent.TimeUnit;

public class Timeout {

    // Слепой таймаут
    private static void blindTimeOut (int sec){
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("Wait {int}")
    public void waitIsSec(int sec) {
        blindTimeOut(sec);
    }

}
