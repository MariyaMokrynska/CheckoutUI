@ALSEP4-341
Feature: Checkout process with payment plan selection

  As a customer, I should be able to click on the next button on step 2 when I select a plan and proceed with the checkout.

  @ALSEP4-341_AC01_TC01
  Scenario Outline: Verify the next button becomes active after selecting a plan
    Given the user is on the enrollment page "<program code>"
    And the user has completed step one with valid information
    And the user is on step two of the enrollment process
    When the user selects the Upfront payment plan
    When the user clicks the next button
    Then the user should be on the review page
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |

  @ALSEP4-341_AC02_TC02
  Scenario Outline: Verify the stepper shows steps 1 and 2 in green, and step 3 in blue
    Given the user is on the enrollment page "<program code>"
    And the user has completed step one with valid information
    And the user is on step two of the enrollment process
    When the user selects the Upfront payment plan
    And the user clicks the next button
    And the user should be on the review page
    Then the stepper should display Step 1 and Step 2 in green and Step 3 should be highlighted in blue
    Then the system should display the steps of the checkout process as:
      | Step Number | Step Name          |
      | 1           | Start Application  |
      | 2           | Payment plan       |
      | 3           | Review             |

    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |

  @ALSEP4-341_AC03_TC03
  Scenario Outline: Verify payment component, price summary, and buttons are displayed
    Given the user is on the enrollment page "<program code>"
    And the user has completed step one with valid information
    And the user is on step two of the enrollment process
    When the user selects the Upfront payment plan
    And the user clicks the next button
    And the user should be on the review page
    Then a price summary should be displayed
    And the back button should be displayed
    Then the payment component should be displayed
    And by default, the pay button should be displayed

    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |


