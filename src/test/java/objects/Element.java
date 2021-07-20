package objects;

import com.codeborne.selenide.SelenideElement;
import pages.Hub;
import pages.Page;

import static com.codeborne.selenide.Selenide.$x;

public class Element {

  String page, key, index, text, containerKey;

  public Element(String page, String key, String index, String text, String containerKey) {
    this.page = page;
    this.key = key;
    this.index = index;
    this.text = text;
    this.containerKey = containerKey;
  }

  public String getPage() {
    return this.page;
  }

  public String getKey() {
    return this.key;
  }

  public String getIndex() {
    if (this.index == null) {
      this.index = "";
    }
    return this.index;
  }

  public String getText() {
    return this.text;
  }

  public String getContainerKey() {
    if (this.containerKey == null) {
      this.containerKey = "";
    }
    return this.containerKey;
  }

  public String getContainerSelector() {
    return Page.getLocator(Hub.getPageElements(this.page), this.containerKey);
  }

  public String getRootSelector() {
    return Page.getLocator(Hub.getPageElements(this.page), this.key);
  }

  public String getSelector() {
    String selector = getRootSelector();
    if (this.containerKey != null && !this.containerKey.equals("")) {
      selector = getContainerSelector().concat(getRootSelector());
    }
    if (this.index != null && !this.index.equals("")) {
      selector = selector.concat(String.format("//*[@index='%s']", this.index));
    }
    return selector;
  }

  public SelenideElement getSelenideElement() {
    return $x(getSelector());
  }

  public String getElementInfo() {
    return String.format(
        "\nPage:\t\t\t%s\nContainer:\t\t%s\nKey:\t\t\t%s\nIndex:\t\t\t%s\nFinal selector:\t%s\n",
        getPage(), getContainerKey(), getKey(), getIndex(), getSelector());
  }
}
