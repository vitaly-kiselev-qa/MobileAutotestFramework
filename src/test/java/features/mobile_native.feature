# language: en

@native
Feature: Wiki example native tests

  Scenario: Swipe onboarding (fail)
    When Simple swipe "Left"
    When Simple swipe "Right"

  Scenario: Skip onboarding
    When Push the skip btn
    Then Feed exists "true"
    Then Feed exists "false"
    When Simple swipe "Down"

  Scenario: Push the button (fail)
    When Simple swipe "Down"
    Then Push the button one
    Then Simple swipe "Up"
