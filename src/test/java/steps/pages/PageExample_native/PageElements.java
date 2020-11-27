package steps.pages.PageExample_native;

import com.codeborne.selenide.SelenideElement;
import ui.actions.Locators;

// Класс ui.Page Object паттерна, где находятся локаторы всех элементов экрана
public class PageElements {

    public final static SelenideElement
            button_one = Locators.setLocatorsForNativeApps(
                    Locators.getLocatorByResourceId("android_id"), //button_payment
                    Locators.getLocatorByResourceId("ios_id")),
            button_two = Locators.setLocatorsForNativeApps(
                    Locators.getLocatorByResourceId("android_id"),
                    Locators.getLocatorByResourceId("ios_id")),
            text_field_one = Locators.setLocatorsForNativeApps(
                    Locators.getLocatorByResourceId("android_id"),
                    Locators.getLocatorByResourceId("ios_id")),
            text_field_two = Locators.setLocatorsForNativeApps(
                    Locators.getLocatorByResourceId("android_id"),
                    Locators.getLocatorByResourceId("ios_id")),

    // wiki example
            wiki_skip_btn = Locators.setLocatorsForNativeApps(
                    Locators.getLocatorByResourceId("fragment_onboarding_skip_button"),
                    Locators.getLocatorByResourceId("fragment_onboarding_skip_button")),
            wiki_feed_container = Locators.setLocatorsForNativeApps(
                    Locators.getLocatorByResourceId("fragment_feed_feed"),
                    Locators.getLocatorByResourceId("fragment_feed_feed"));
}


