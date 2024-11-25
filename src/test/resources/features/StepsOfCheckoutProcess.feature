@ALSEP4-334
Feature: Display the steps of the checkout process

  As a customer, I should be able to know where I am in the checkout process using the stepper

  @ALSEP4-334_AC01_TC01
  Scenario Outline: Verify the stepper displays correct step names
    Given the user is on the enrollment page "<program code>"
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

  @ALSEP4-334_AC02_TC01
  Scenario Outline: Verify "Start Application" step is highlighted in blue
    Given the user is on the enrollment page "<program code>"
    Then the system should highlight the "Start Application" step in blue
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |

  @ALSEP4-334_AC03_TC01
  Scenario Outline: Verify "Payment plan" and "Review" steps have no color
    Given the user is on the enrollment page "<program code>"
    Then the system should display "Payment plan" and "Review" steps with no color
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |