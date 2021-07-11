package steps.common;

import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.setup.Hub;
import pages.setup.Page;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class CheckElements {

    @When("^Check elements (exist|not exist)$")
    public void checkElements(String variant, DataTable dataTable) {

        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : table) {
            String elementRootLocator = Page.getLocator(Hub.getPageElements(columns.get("page")), columns.get("element"));

            if (variant.contains("not")) {
                checkElementNotExist(
                        elementRootLocator,
                        columns.get("containsText"),
                        columns.get("exactText")
                );
            } else {
                checkElementExist(
                        elementRootLocator,
                        columns.get("containsText"),
                        columns.get("exactText")
                );
            }
        }
    }

    public void checkElementExist(
            String elementRootLocator,
            String containsText,
            String exactText
    ) {
        $x(elementRootLocator).shouldBe(Condition.exist);
        if (containsText != null && containsText != "") {
            $x(elementRootLocator).shouldBe(Condition.text(containsText));
        }
        if (exactText != null && exactText != "") {
            $x(elementRootLocator).shouldBe(Condition.exactText(exactText));
        }
    }

    public void checkElementNotExist(
            String elementRootLocator,
            String containsText,
            String exactText
    ) {
        $x(elementRootLocator).shouldNotBe(Condition.exist);
        if (containsText != null && containsText != "") {
            $x(elementRootLocator).shouldNotBe(Condition.text(containsText));
        }
        if (exactText != null && exactText != "") {
            $x(elementRootLocator).shouldNotBe(Condition.exactText(exactText));
        }
    }
}

