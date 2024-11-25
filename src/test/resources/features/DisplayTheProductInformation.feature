@ALSEP4-335
Feature: Display the product information

  @ALSEP4-335_AC01_TC01
  Scenario Outline: Product name should be displayed on the information card
    Given the user is on the enrollment page "<program code>"
    Then product name should be displayed on the information card.

    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |

  @ALSEP4-335_AC02_TC01
  Scenario Outline: Product name on the information card matches the name on the left side
    Given the user is on the enrollment page "<program code>"
    Then product name on the information card matches the product name on the left side of the screen.

    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |

  @ALSEP4-335_AC03_TC01
  Scenario Outline: Base price of the product should be clearly displayed
    Given the user is on the enrollment page "<program code>"
    Then the base price of the product should be clearly displayed for "<program code>"

    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |

  @ALSEP4-335_AC04_TC01
  Scenario Outline: Flexible payment plan text should be displayed
    Given the user is on the enrollment page "<program code>"
    Then text indicating a flexible payment plan should be available and displayed.

    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |

  @ALSEP4-335_AC05_TC01
  Scenario Outline: Program start date should be displayed
    Given the user is on the enrollment page "<program code>"
    Then the program start date should be displayed for "<program code>"

    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |

  @ALSEP4-335_AC06_TC01
  Scenario Outline: Return policy and final date for returns should be displayed
    Given the user is on the enrollment page "<program code>"
    Then the return policy and the final date for returns should be displayed for "<program code>"

    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |