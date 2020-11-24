# language: en

@web
Feature: Wiki example web tests

  Scenario: Try to open url
    When Open url "http://appium.io/docs/en/writing-running-appium/web/mobile-web/"

  Scenario: Skip onboarding
    When Swipe "Down"

  Scenario: Push the button (fail)
    When Swipe "Down"