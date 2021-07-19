package steps.actions;



import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import objects.Element;
import steps.common.CheckElement;

import java.util.List;
import java.util.Map;

public class CheckElements {

    @When("Check elements {string}")
    public static void checkElements(String variant, DataTable dataTable) {

        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : table) {
            Element element = new Element(
                    columns.get("page"),
                    columns.get("element"),
                    columns.get("index"),
                    columns.get("container")
            );
            CheckElement.check(
                    variant,
                    element,
                    columns.get("text")
            );
        }
    }
}

