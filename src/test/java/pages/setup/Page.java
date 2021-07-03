package pages.setup;

import com.codeborne.selenide.SelenideElement;
import ui.Config;

import static com.codeborne.selenide.Selenide.$x;

public interface Page {

    Element[] getElements();

    static SelenideElement getElement(Element[] elements, String key) {
        String element ="" ;
        for( int i = 0; i < elements.length; i++){
            if (elements[i].key == key) {
                switch (Config.getCurrentPlatformName()) {
                    case ANDROID_NATIVE: element = elements[i].androidEl; break;
                    case IOS_NATIVE: element = elements[i].iosEl; break;
                    default: System.out.print("ERROR: Undefined platform. Android set as default platform");
                }
            }
        }
        return $x(element);
    }


}
