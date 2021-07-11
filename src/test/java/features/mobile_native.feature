# language: en

@native
Feature: Wiki example native tests

  Scenario: Check elements example
    When Start the app
    When Check elements exist
      | page       | element    |
      | Start page | Header     |
      | Start page | Sub header |
    When Check elements not exist
      | page       | element      |
      | Start page | Super header |

    When Simple swipe "Left"
    When Simple swipe "Left"
    When Simple swipe "Right"

