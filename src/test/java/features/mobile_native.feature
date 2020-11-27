# language: en

@native
Feature: Wiki example native tests

  Scenario: Swipe onboarding (fail)
    When Simple swipe "Left"
    Then Feed exists "false"
    Then Feed exists "true"
    When Simple swipe "Right"

  Scenario: Skip onboarding
    When Push the skip btn
    Then Feed exists "true"
    When Simple swipe "Down"

  Scenario: Push the button (fail)
    When Simple swipe "Down"
    Then Push the button one
    Then Simple swipe "Up"