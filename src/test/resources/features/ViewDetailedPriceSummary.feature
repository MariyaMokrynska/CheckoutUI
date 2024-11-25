@ALSEP4-351
Feature: View a detailed price summary
  As a user, I want to see detailed price summaries when I select different pricing options,
  to help me make an informed decision in step 2.

  @ALSEP4-351_AC01_TC01
  Scenario Outline: while on 2nd page the user clicks on any accordion, it should expand to open the price details
    Given the user is on the enrollment page "<program code>"
    And the user has completed step one with valid information
    When the user clicks on any accordion, it should expand to open the price details
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |

  @ALSEP4-351_AC02_TC01
  Scenario Outline: Price details for each price type follow the test-data provided json
    Given the user is on the enrollment page "<program code>"
    And the user has completed step one with valid information
    When the user clicks on any accordion, it should expand to open the price details
    Then Price details for each price type follow the test-data in provided json "<program code>"
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |


  @ALSEP4-351_AC03_TC01
  Scenario Outline: Each price summary must say excluding fees at the end
    Given the user is on the enrollment page "<program code>"
    And the user has completed step one with valid information
    When the user clicks on any accordion, it should expand to open the price details
    Then Price details for each price type follow the test-data in provided json "<program code>"
    Then Each price summary must say excluding fees at the end
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |