# language: en

@native
Feature: Wiki example native tests

  Scenario: Check elements example
    When Start the app
    When Check elements exist
      | page       | element    | containsText             |
      | Start page | Header     |                          |
      | Start page | Sub header | Мы нашли следующие языки |
    When Check elements not exist
      | page       | element      |
      | Start page | Super header |

    When Simple swipe "Left"
    When Simple swipe "Left"
    When Simple swipe "Right"
    When Stop the app

