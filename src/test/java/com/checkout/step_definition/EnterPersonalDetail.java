package com.checkout.step_definition;

import com.checkout.pages.StartApplicationPage;
import com.checkout.utilities.BrowserUtils;
import com.checkout.utilities.DriverUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Driver;

import static org.junit.Assert.*;

public class EnterPersonalDetail {
    StartApplicationPage startApplicationPage = new StartApplicationPage();

    @Then("the {string} field is present")
    public void theFieldIsPresent(String fieldName) {
        switch (fieldName) {

            case "Parent First Name":
                Assert.assertTrue(startApplicationPage.parentFirstNameInputBox.isDisplayed());
            case "Parent Last Name":
                Assert.assertTrue(startApplicationPage.parentLastNameInputBox.isDisplayed());
            case "Parent Email Address":
                Assert.assertTrue(startApplicationPage.parentAddressInputBox.isDisplayed());
            case "Parent Phone":
                Assert.assertTrue(startApplicationPage.parentPhoneNumberInputBox.isDisplayed());
        }

    }

    @And("the {string} field validates for email formats")
    public void theFieldValidatesForEmailFormats(String fieldName) {
        switch (fieldName) {
            case "Email Address":
                assertEquals("email", startApplicationPage.emailInputBox.getAttribute("type"));
            case "Parent Email Address":
                assertEquals("email", startApplicationPage.parentAddressInputBox.getAttribute("type"));

        }

    }

    @And("the {string} field allows numbers only")
    public void theFieldAllowsNumbersOnly(String str) {
        // Test valid input (numbers only)

        startApplicationPage.parentPhoneNumberInputBox.sendKeys("1234567890");
        assertEquals("1234567890", startApplicationPage.parentPhoneNumberInputBox.getAttribute("value"));

        // Test invalid input (contains non-numeric characters)

        startApplicationPage.parentPhoneNumberInputBox.sendKeys("123abc456");
        String resultValue = startApplicationPage.parentPhoneNumberInputBox.getAttribute("value");
        Assert.assertTrue("Non-numeric characters were accepted", resultValue.matches("^[0-9]*$"));

        // Test with special characters
        startApplicationPage.parentPhoneNumberInputBox.clear();
        startApplicationPage.parentPhoneNumberInputBox.sendKeys("123@#$456");
        resultValue = startApplicationPage.parentPhoneNumberInputBox.getAttribute("value");
        Assert.assertTrue("Special characters were accepted", resultValue.matches("^[0-9]*$"));

    }

    @And("How did you hear about us? A standard dropdown list is present")
    public void howDidYouHearAboutUsAStandardDropdownListIsPresent() {
        Assert.assertTrue(startApplicationPage.howDidYouHearAboutUsDropDown.isDisplayed());
    }

    @Then("the First Name field is present")
    public void theFirstNameFieldIsPresent() {
        Assert.assertTrue(startApplicationPage.firstNameInputBox.isDisplayed());
    }

    @And("the Last Name field is present")
    public void theLastNameFieldIsPresent() {
        Assert.assertTrue(startApplicationPage.lastNameInputBox.isDisplayed());
    }

    @And("the Email Address field is present")
    public void theEmailAddressFieldIsPresent() {
        Assert.assertTrue(startApplicationPage.emailInputBox.isDisplayed());
    }

    @And("the Email Address field validates for email formats")
    public void theEmailAddressFieldValidatesForEmailFormats() {
        Assert.assertTrue(startApplicationPage.emailInputBox.getAttribute("type").equalsIgnoreCase("email"));
    }

    @And("the Phone field is present")
    public void thePhoneFieldIsPresent() {
        Assert.assertTrue(startApplicationPage.phoneNumberInputBox.isDisplayed());
    }

    @When("the user enter {string} in the phone field")
    public void theUserEnterInThePhoneField(String arg0) {
    }

    @And("the Phone field allows numbers only")
    public void thePhoneFieldAllowsNumbersOnly() {

        startApplicationPage.checkThePhoneNumber(startApplicationPage.phoneNumberInputBox);


    }

    @When("the user leaves one or more required fields empty")
    public void theUserLeavesOneOrMoreRequiredFieldsEmpty() {
        startApplicationPage.firstNameInputBox.clear();

    }


    @When("the user enters invalid data in one or more fields")
    public void theUserEntersInvalidDataInOneOrMoreFields() {
        startApplicationPage.firstNameInputBox.sendKeys("123");
        startApplicationPage.lastNameInputBox.sendKeys("123");
        startApplicationPage.emailInputBox.sendKeys("Invalid-email");
        startApplicationPage.phoneNumberInputBox.sendKeys("123abc");

    }

    @Then("the Next button should be disabled")
    public void theNextButtonShouldBeDisabled() {
        assertFalse("Next button should be disabled when required fields are empty", startApplicationPage.nextButton.isEnabled());
    }

    @When("the user enters invalid data in the {string} field")
    public void theUserEntersInvalidDataInTheField(String arg0) {
        startApplicationPage.firstNameInputBox.click();
        startApplicationPage.nextButton.click();

    }

    @When("the user does not provide any information")
    public void theUserDoesNotProvideAnyInformation() {
        BrowserUtils.sleep(3);
        BrowserUtils.scrollToElement(startApplicationPage.nextButton);
        BrowserUtils.sleep(3);
        startApplicationPage.nextButton.click();
        BrowserUtils.sleep(3);

    }

    @Then("the labels for all the fields should turn red")
    public void theLabelsForAllTheFieldsShouldTurnRed() {
        startApplicationPage.checkTheColor(startApplicationPage.firstNameLabel);
        startApplicationPage.checkTheColor(startApplicationPage.lastNameLabel);
        startApplicationPage.checkTheColor(startApplicationPage.emailLabel);
        startApplicationPage.checkTheColor(startApplicationPage.phoneLabel);
    }

    @When("the user enters invalid email address in the Email field")
    public void theUserEntersInvalidEmailAddressInTheEmailField() {
        startApplicationPage.emailInputBox.sendKeys("invalid-email");
        startApplicationPage.nextButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("the label for the email field should turn red")
    public void theLabelForTheEmailFieldShouldTurnRed() {
        startApplicationPage.checkTheColor(startApplicationPage.emailLabel);
    }

    @When("the user enters invalid data in the Phone field")
    public void theUserEntersInvalidDataInThePhoneField() {
        startApplicationPage.phoneNumberInputBox.sendKeys("123abc");
        startApplicationPage.nextButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("the label for the Phone field should turn red")
    public void theLabelForThePhoneFieldShouldTurnRed() {
        startApplicationPage.checkTheColor(startApplicationPage.phoneLabel);
    }

    @Then("the parent Phone field allows numbers only")
    public void theParentPhoneFieldAllowsNumbersOnly() {
        startApplicationPage.checkThePhoneNumber(startApplicationPage.parentPhoneNumberInputBox);
    }

    @When("the user leaves one or more required parent's fields empty")
    public void theUserLeavesOneOrMoreRequiredParentSFieldsEmpty() {
        startApplicationPage.parentFirstNameInputBox.clear();
        startApplicationPage.parentLastNameInputBox.clear();
        startApplicationPage.parentAddressInputBox.clear();
        startApplicationPage.parentPhoneNumberInputBox.clear();
    }

    @When("the user enters invalid data in one or more parent fields")
    public void theUserEntersInvalidDataInOneOrMoreParentFields() {
        startApplicationPage.parentFirstNameInputBox.sendKeys("123");
        startApplicationPage.parentLastNameInputBox.sendKeys("123");
        startApplicationPage.parentAddressInputBox.sendKeys("Invalid-email");
        startApplicationPage.parentPhoneNumberInputBox.sendKeys("123abc");
    }

    @Then("the labels for all fields should turn red")
    public void theLabelsForAllFieldsShouldTurnRed() {
        startApplicationPage.checkTheColor(startApplicationPage.firstNameLabel);
        startApplicationPage.checkTheColor(startApplicationPage.lastNameLabel);
        startApplicationPage.checkTheColor(startApplicationPage.emailLabel);
        startApplicationPage.checkTheColor(startApplicationPage.phoneLabel);
        startApplicationPage.checkTheColor(startApplicationPage.parentFirstNameLabel);
        startApplicationPage.checkTheColor(startApplicationPage.parentLastNameLabel);
        startApplicationPage.checkTheColor(startApplicationPage.parentEmailLabel);
        startApplicationPage.checkTheColor(startApplicationPage.parentPhoneLabel);

    }

    @When("the user enters invalid email address in the Parent Email Address field")
    public void theUserEntersInvalidEmailAddressInTheParentEmailAddressField() {
        BrowserUtils.scrollToElement(startApplicationPage.parentAddressInputBox);
        startApplicationPage.parentAddressInputBox.sendKeys("invalid-email");
        BrowserUtils.sleep(2);
    }

    @Then("the label for the parent email address field should turn red")
    public void theLabelForTheParentEmailAddressFieldShouldTurnRed() {
        startApplicationPage.checkTheColor(startApplicationPage.parentEmailLabel);
    }

    @When("the user enters invalid data in the Parent Phone field")
    public void theUserEntersInvalidDataInTheParentPhoneField() {
        startApplicationPage.parentPhoneNumberInputBox.sendKeys("123abc");
        BrowserUtils.sleep(3);
        BrowserUtils.scrollToElement(startApplicationPage.nextButton);
        BrowserUtils.sleep(3);
        startApplicationPage.nextButton.click();
        BrowserUtils.sleep(3);
    }

    @Then("the label for the Parent Phone field should turn red")
    public void theLabelForTheParentPhoneFieldShouldTurnRed() {
        startApplicationPage.checkTheColor(startApplicationPage.parentPhoneLabel);
    }

    @When("the user enters invalid data in the Phone input field")
    public void theUserEntersInvalidDataInThePhoneInputField() {
        startApplicationPage.phoneNumberInputBox.sendKeys("123abc");
    }

}

