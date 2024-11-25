@ALSEP4-333
Feature: View the product landing page
  As a customer, I should be able to see the product landing page.

  @ALSEP4-333_AC01_TC01
  Scenario Outline: Display product landing page name
    Given the user is on the enrollment page "<program code>"
    Then the system should display the text "Sample Academy Secure Checkout"
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |


  @ALSEP4-333_AC02_TC01
  Scenario Outline: Display program name on product landing page
    Given the user is on the enrollment page "<program code>"
    Then the system should display the "<program title>"
    Examples:
      | program code |  program title                        |
      | atf          |  Automated Testing Fundamentals       |
      | fwdp         |  Frontend Web Development Program     |
      | jbtp         |  Java Basics For Teens Program        |
      | aqaas        |  Advanced QA Automation with Selenium |

  @ALSEP4-333_AC03_TC01
  Scenario Outline: Display left footer information in order
    Given the user is on the enrollment page "<program code>"
    Then the footer should contain the following items in order on the left side:
      | logo                  |
      | Terms and Conditions  |
      | Privacy Policy        |
      | Disclaimer            |
      | Cookie Policy         |
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |

  @ALSEP4-333_AC04_TC01
  Scenario Outline: Display right footer information
    Given the user is on the enrollment page "<program code>"
    Then the footer should display "Need help? Contact us at sampleacademy.com" on the right
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |
