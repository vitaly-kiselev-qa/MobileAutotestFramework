package steps.table_actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import objects.Element;
import steps.common_actions.ElementActions;

import java.util.List;
import java.util.Map;

public class ClickElements {

    @When("Click element")
    @When("Click multiple elements in sequence")
    public static void clickElementsMulti(DataTable dataTable) {

        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> item : table) {
            Element element = new Element(
                    item.get("page"),
                    item.get("element"),
                    item.get("index"),
                    item.get("text"),
                    item.get("container")
            );
            ElementActions.clickElement(element);
        }
    }
}
