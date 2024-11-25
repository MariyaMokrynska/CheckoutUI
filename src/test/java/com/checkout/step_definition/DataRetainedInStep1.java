package com.checkout.step_definition;

import com.checkout.pages.PaymentPlanPage;
import com.checkout.pages.StartApplicationPage;
import com.checkout.utilities.BrowserUtils;
import com.checkout.utilities.DriverUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class DataRetainedInStep1 {

    private StartApplicationPage startApplicationPage = new StartApplicationPage();
    private PaymentPlanPage paymentPlanPage = new PaymentPlanPage();

    public DataRetainedInStep1() {
    }

    @When("the user clicks the back button")
    public void theUserClicksTheBackButton() {
        paymentPlanPage.backButton.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("the step one form should display the retained customer information")
    public void theStepOneFormShouldDisplayTheRetainedCustomerInformation() {
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitForVisibility(startApplicationPage.firstNameInputBox, 10);
        BrowserUtils.waitFor(2);


        String expectedFirstName = "James";
        String expectedLastName = "Bond";
        String expectedEmail = "James_Bond@gmail.com";
        String expectedPhoneNumber = "1234567890";


        Map<String, String> actualUserFields = startApplicationPage.getUserFields();


        Assert.assertEquals("First name doesn't match", expectedFirstName, actualUserFields.get("firstName"));
        Assert.assertEquals("Last name doesn't match", expectedLastName, actualUserFields.get("lastName"));
        Assert.assertEquals("Email doesn't match", expectedEmail, actualUserFields.get("email"));
        Assert.assertEquals("Phone number doesn't match", expectedPhoneNumber, actualUserFields.get("phoneNumber"));
    }

    @When("the user refreshes the page")
    public void theUserRefreshesThePage() {
        DriverUtils.getDriver().navigate().refresh();
        BrowserUtils.waitForPageToLoad(20);
    }

    @Then("the step one form should display the default information")
    public void theStepOneFormShouldDisplayTheDefaultInformation() {
        BrowserUtils.waitForPageToLoad(10);


        Map<String, String> actualUserFields = startApplicationPage.getUserFields();


        Assert.assertTrue("First name should be empty", actualUserFields.get("firstName").isEmpty());
        Assert.assertTrue("Last name should be empty", actualUserFields.get("lastName").isEmpty());
        Assert.assertTrue("Email should be empty", actualUserFields.get("email").isEmpty());
        Assert.assertTrue("Phone number should be empty", actualUserFields.get("phoneNumber").isEmpty());
    }


}
