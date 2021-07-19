# language: en

@native
Feature: Wiki example native tests

  Scenario: Check elements example
    When Start the app
    When Check elements "exist"
      | page       | element    | text                     |
      | Start page | Header     |                          |
      | Start page | Sub header | Мы нашли следующие языки |
    When Check elements "not exist"
      | page       | element      | text                 | index |
      | Start page | Header       | Несуществующий текст |       |
      | Start page | Sub header   | Несуществующий текст |       |
      | Start page | Super header |                      |       |
    When Click elements
      | page       | element      |
      | Start page | Add lang btn |

    When Simple swipe "Left"
    When Simple swipe "Left"
    When Simple swipe "Right"
    When Stop the app

