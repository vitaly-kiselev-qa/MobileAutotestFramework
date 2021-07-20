package steps.table_actions;


import enums.Browsers;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import objects.Element;
import steps.common_actions.ElementActions;

import java.util.List;
import java.util.Map;

public class CheckElements {

    @When("Check elements {string}")
    public static void checkElements(String variant, DataTable dataTable) {

        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> item : table) {
            Element element = new Element(
                    item.get("page"),
                    item.get("element"),
                    item.get("index"),
                    item.get("text"),
                    item.get("container")
            );
            ElementActions.check(variant, element);
        }
    }
}

