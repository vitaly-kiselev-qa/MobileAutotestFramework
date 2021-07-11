package steps.common;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.setup.Locator;
import pages.setup.Hub;
import pages.setup.Page;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;
import static steps.app.Context.setContextByName;

public class CheckElements {

    @When("^Check elements (exist|not exist)$")
    public void checkElements(String variant, DataTable dataTable) {

        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : table) {
            SelenideElement element = $x(Page.getLocator(
                    Hub.getPageElements(columns.get("page")),
                    columns.get("element")
            ));
            if (variant.contains("not")) {
                element.shouldNotBe(Condition.exist);
            } else {
                element.shouldBe(Condition.exist);
            }

            System.out.println( String.format("TRY TO FIND ELEMENT\nPage:\t\t%s\nElement:\t%s\n",
                    columns.get("page"),
                    columns.get("element")
                    )
            );
        }
    }
}
