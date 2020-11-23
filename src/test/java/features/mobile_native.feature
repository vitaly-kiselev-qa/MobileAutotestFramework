# language: en

@smoke
Feature: Wiki example tests

  Scenario: Swipe onboarding (fail)
    When Swipe "Left"
    Then Feed exists "false"
    Then Feed exists "true"
    When Swipe "Right"

  Scenario: Skip onboarding
    When Push the skip btn
    Then Feed exists "true"
    When Swipe "Down"

  Scenario: Push the button (fail)
    When Swipe "Down"
    Then Push the button one
    Then Swipe "Up"