package com.checkout.step_definition;

import com.checkout.pages.PaymentPlanPage;
import com.checkout.pages.StartApplicationPage;
import com.checkout.pages.ReviewPlanPage;
import com.checkout.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.Color;

import java.util.List;
import java.util.Map;

public class ClickOnTheNextOnPaymentPlan {

    private StartApplicationPage startApplicationPage = new StartApplicationPage();
    private PaymentPlanPage paymentPlanPage = new PaymentPlanPage();
    private ReviewPlanPage reviewPlanPage = new ReviewPlanPage();


    @When("the user clicks the next button")
    public void theUserClicksTheNextButton() {
        paymentPlanPage.activeNextButton.click();
    }

    @Then("the user should be on the review page")
    public void theUserShouldBeOnTheReviewPage() {
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertTrue("Review step circle is not displayed", startApplicationPage.reviewStepCircle.isDisplayed());
    }

    @Then("the stepper should display Step {int} and Step {int} in green and Step {int} should be highlighted in blue")
    public void theStepperShouldDisplayStepsInGreenAndHighlightedInBlue(Integer step1, Integer step2, Integer finalStep) {

        String expectedGreenColor = "#acf58a"; // Expected green
        String expectedBlueColor = "#01c9ff";  // Expected blue

        if (step1.equals(1)) {
            String color = startApplicationPage.startApplicationStepCircle.getCssValue("background-color");
            Assert.assertEquals("Expected green color for Step 1", expectedGreenColor, Color.fromString(color).asHex());
        }

        if (step2.equals(2)) {
            String color = startApplicationPage.paymentPlanStepCircle.getCssValue("background-color");
            if (Color.fromString(color).asHex().equals(expectedBlueColor)) {
                System.out.println("DEBUG: Step 2 is showing blue instead of green. Possible issue.");
            }
            Assert.assertEquals("Expected green color for Step 2", expectedGreenColor, Color.fromString(color).asHex());
        }

        if (finalStep.equals(3)) {
            String color = startApplicationPage.reviewStepCircle.getCssValue("background-color");
            Assert.assertEquals("Expected blue color for Step 3", expectedBlueColor, Color.fromString(color).asHex());
        }
    }

    @Then("a price summary should be displayed")
    public void aPriceSummaryShouldBeDisplayed() {
        BrowserUtils.waitForVisibility(reviewPlanPage.productPriceAmount, 10);
        Assert.assertTrue("Payment component is not displayed", reviewPlanPage.productPriceAmount.isDisplayed());

    }

    @And("the back button should be displayed")
    public void theBackButtonShouldBeDisplayed() {
        Assert.assertTrue("Back button is not displayed", reviewPlanPage.backButton.isDisplayed());
    }

    @Then("the payment component should be displayed")
    public void thePaymentComponentShouldBeDisplayed() {
        Assert.assertTrue("Price summary is not displayed", reviewPlanPage.productPriceAmount.isDisplayed());
    }

    @And("by default, the pay button should be displayed")
    public void byDefaultThePayButtonShouldBeDisplayed() {
        Assert.assertTrue("Pay button is not displayed", reviewPlanPage.payButton.isDisplayed());
    }
}
