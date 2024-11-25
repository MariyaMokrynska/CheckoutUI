@ALSEP4-337
Feature: Data retention behavior in Step 1

  As a customer, I should be able to retain information on Step 1 when navigating back, but information should not be saved after refreshing the page.


Scenario Outline: Data should be retained when using the back button in every environment
  Given the user is on the enrollment page "<program code>"
  And the user has completed step one with valid information
  And the user is on step two of the enrollment process
  When the user clicks the back button
  Then the step one form should display the retained customer information

  Examples:
    | program code |
    | atf          |
    | fwdp         |
    | jbtp         |
    | aqaas        |

  Scenario Outline: Information should not be retained after page refresh in every environment
    Given the user is on the enrollment page "<program code>"
    And the user has completed step one with valid information
    When the user refreshes the page
    Then the step one form should display the default information

    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |



