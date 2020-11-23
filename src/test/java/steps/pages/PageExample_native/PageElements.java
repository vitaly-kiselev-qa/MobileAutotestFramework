package steps.pages.PageExample_native;

import com.codeborne.selenide.SelenideElement;
import steps.Page;

// Класс Page Object паттерна, где находятся локаторы всех элементов экрана
public class PageElements implements Page {

    public final static SelenideElement
            button_one = Page.setLocators(
                    Page.getLocatorByResourceId("android_id"), //button_payment
                    Page.getLocatorByResourceId("ios_id")),
            button_two = Page.setLocators(
                    Page.getLocatorByResourceId("android_id"),
                    Page.getLocatorByResourceId("ios_id")),
            text_field_one = Page.setLocators(
                    Page.getLocatorByResourceId("android_id"),
                    Page.getLocatorByResourceId("ios_id")),
            text_field_two = Page.setLocators(
                    Page.getLocatorByResourceId("android_id"),
                    Page.getLocatorByResourceId("ios_id")),

    // wiki example
            wiki_skip_btn =
                    Page.setLocators(Page.getLocatorByResourceId("fragment_onboarding_skip_button"),
                    Page.getLocatorByResourceId("fragment_onboarding_skip_button"));
}


