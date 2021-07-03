package steps.common;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.setup.Element;
import pages.setup.Hub;
import pages.setup.Page;

public class CheckElements {

    @When("{string}: check elements exist")
    public void checkElements(String page, DataTable table) {
        Element[] elements = Hub.getPageElements(page);
        Page.getElement(elements, "Элемент");

        System.out.println(table.asList());

        /*
        [
                {"title": "The Devil in the White City", "author": "Erik Larson"},
                {"title": "The Lion, the Witch and the Wardrobe", "author": "C.S. Lewis"},
                {"title": "In the Garden of Beasts", "author": "Erik Larson"}
        ]
         */

    }
}
