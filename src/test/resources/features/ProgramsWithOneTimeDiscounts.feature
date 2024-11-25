@ALSEP4-339
Feature: Programs with one-time discounts

  As a user, I want to see programs with one-time discounts so that I can understand the savings I will receive
  if I pay upfront.

  @ALSEP4-339_AC01_TC01
  Scenario Outline: Display full price with strike-through on Step 1
    Given the user is on the enrollment page "<program code>"
    Then the full price should be displayed with a strike-through
    Examples:
      | program code |
      | atf          |
      | jbtp         |
      | aqaas        |

  @ALSEP4-339_AC01_TC02
  Scenario Outline: Display discounted price in blue on Step 1
    Given the user is on the enrollment page "<program code>"
    Then the discounted price should be shown in blue

    Examples:
      | program code |
      | atf          |
      | jbtp         |
      | aqaas        |

  @ALSEP4-339_AC02_TC01
  Scenario Outline: Display discount amount in a green badge on Step 2
    Given the user is on the enrollment page "<program code>"
    And the user has completed step one with valid information
    And the user is on step two of the enrollment process
    Then the discount amount should be displayed on a green badge

    Examples:
      | program code |
      | atf          |
      | jbtp         |
      | aqaas        |

  @ALSEP4-339_AC02_TC02
  Scenario Outline: Display correct text on green badge in Step 2
    Given the user is on the enrollment page "<program code>"
    And the user has completed step one with valid information
    And the user is on step two of the enrollment process
    Then the badge text should read: "$<discount_amount> Upfront discount"

    Examples:
      | program code | discount_amount |
      | atf          | 100             |
      | jbtp         | 50              |
      | aqaas        | 100             |
