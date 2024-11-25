@ALSEP-336
Feature: Enter my Personal details
  As a customer, I should be able to enter my Personal details.

  @ALSEP-336_AC1_TC01
  Scenario Outline: Verify default field types and values in the registration form
    Given the user is on the enrollment page "<program code>"
    Then the First Name field is present
    And the Last Name field is present
    And the Email Address field is present
    And the Email Address field validates for email formats
    And the Phone field is present
    And the Phone field allows numbers only
    And How did you hear about us? A standard dropdown list is present
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |

  @ALSEP-336_AC1_TC02
  Scenario:Verify the extra fields for parent information
    Given the user is on the enrollment page "jbtp"
    Then the "Parent First Name" field is present
    And the "Parent Last Name" field is present
    And the "Parent Email Address" field is present
    And the "Parent Email Address" field validates for email formats
    And the "Parent Phone" field is present
    And the parent Phone field allows numbers only

  @ALSEP-336_AC2_TC01
  Scenario Outline: Verify the 'Next' button is disabled when required fields are empty
    Given the user is on the enrollment page "<program code>"
    When the user leaves one or more required fields empty
    Then the Next button should be disabled
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |

  @ALSEP-336_AC2_TC02
  Scenario Outline: Verify the 'Next' button is disabled when data is invalid
    Given the user is on the enrollment page "<program code>"
    When the user enters invalid data in one or more fields
    Then the Next button should be disabled
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | jbtp         |
      | aqaas        |

  @ALSEP-336_AC2_TC03
  Scenario:Verify that the 'Next' button should be disabled if any required parent data is missing or invalid.
    Given the user is on the enrollment page "jbtp"
    When the user leaves one or more required parent's fields empty
    Then the Next button should be disabled
    When the user enters invalid data in one or more parent fields
    Then the Next button should be disabled

  @ALSEP-336_AC3_TC01
  Scenario Outline: Verify the input box label becomes red colored if there is an validation issues in the fields.
    Given the user is on the enrollment page "<program code>"
    When the user does not provide any information
    Then the labels for all the fields should turn red
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | aqaas        |

  @ALSEP-336_AC3_TC02
  Scenario Outline: Verify the input box label becomes red colored if there is an validation issues in the fields.
    Given the user is on the enrollment page "<program code>"
    When the user enters invalid email address in the Email field
    When the user enters invalid data in the Phone field
    Then the label for the email field should turn red
    Then the label for the Phone field should turn red
    Examples:
      | program code |
      | atf          |
      | fwdp         |
      | aqaas        |

  @ALSEP-336_AC3_TC03
  Scenario:Verify that the input box label becomes red colored if there is an validation issues in the parent fields.
    Given the user is on the enrollment page "jbtp"
    When the user does not provide any information
    Then the labels for all fields should turn red

  @ALSEP-336_AC3_TC04
  Scenario:Verify that the input box label becomes red colored if there is an validation issues in the parent fields.
    Given the user is on the enrollment page "jbtp"
    When the user enters invalid data in the Phone input field
    And the user enters invalid email address in the Parent Email Address field
    And the user enters invalid data in the Parent Phone field
    Then the label for the Phone field should turn red
    And the label for the parent email address field should turn red
    And the label for the Parent Phone field should turn red


