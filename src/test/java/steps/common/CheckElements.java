package steps.common;

import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import objects.Element;
import java.util.List;
import java.util.Map;

public class CheckElements {

    @When("^Check elements (exist|not exist)$")
    public void checkElements(String variant, DataTable dataTable) {

        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : table) {
            Element element = new Element(
                    columns.get("page"),
                    columns.get("element"),
                    columns.get("index"),
                    columns.get("container")
            );
            System.out.println(element.getElementInfo());

            if (variant.contains("not")) {
                if (columns.get("text") != null && !columns.get("text").equals("")) {
                    element.getSelenideElement().shouldNotBe(Condition.text(columns.get("text")));
                }
            } else {
                element.getSelenideElement().shouldBe(Condition.exist);
                if (columns.get("text") != null && !columns.get("text").equals("")) {
                    element.getSelenideElement().shouldBe(Condition.text(columns.get("text")));
                }
            }
        }
    }
}

