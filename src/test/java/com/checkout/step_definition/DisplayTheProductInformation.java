package com.checkout.step_definition;

import com.checkout.pages.LeftMainPage;
import com.checkout.pages.StartApplicationPage;
import com.checkout.utilities.BrowserUtils;
import com.checkout.utilities.QaDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class DisplayTheProductInformation {
    public LeftMainPage leftMainPage = new LeftMainPage();
    public StartApplicationPage startApplicationPage = new StartApplicationPage();

    @Then("product name should be displayed on the information card.")
    public void product_name_should_be_displayed_on_the_information_card() {
        Assert.assertTrue(startApplicationPage.programNameOnInfoCard.isDisplayed());
    }

    @Then("product name on the information card matches the product name on the left side of the screen.")
    public void product_name_on_the_information_card_matches_the_product_name_on_the_left_side_of_the_screen() {
        BrowserUtils.waitForVisibility(startApplicationPage.programNameOnInfoCard, 10);
        BrowserUtils.waitForVisibility(leftMainPage.programName, 10);
        String actualProgramNameOnInfoCard = startApplicationPage.programNameOnInfoCard.getText();
        String expectedProgramName = leftMainPage.programName.getText();
        Assert.assertEquals(actualProgramNameOnInfoCard, expectedProgramName);
    }

    @And("the base price of the product should be clearly displayed for {string}")
    public void the_base_price_of_the_product_should_be_clearly_displayed_for(String programCode) {
        int expectedBasePrice = QaDataReader.getBaseAmount(programCode);

        WebElement actualPriceElement;
        if ("fwdp".equals(programCode)) {
            actualPriceElement = startApplicationPage.fwdpPrice;
        } else {
            actualPriceElement = startApplicationPage.originalPrice;
        }
//        BrowserUtils.waitForVisibility(actualPriceElement, 10);
        String actualBasePriceText = actualPriceElement.getText();
        String cleanedActualBasePriceText = actualBasePriceText.replaceAll("&nbsp;", "")
                .replaceAll("[^0-9]", "");

        Assert.assertEquals("Expected base price does not match actual base price for program code: "
                + programCode, expectedBasePrice, Integer.parseInt(cleanedActualBasePriceText));
    }

    @And("text indicating a flexible payment plan should be available and displayed.")
    public void text_indicating_a_flexible_payment_plan_should_be_available_and_displayed() {
        Assert.assertTrue(startApplicationPage.flexiblePaymentsPlanAvailableText.isDisplayed());
    }

    @And("the program start date should be displayed for {string}")
    public void the_program_start_date_should_be_displayed_for(String programCode) {
        String expectedStartDate = QaDataReader.getSingleProduct(programCode).getStartDate();
        BrowserUtils.waitForVisibility(startApplicationPage.programStartDate, 10);
        BrowserUtils.waitFor(1);
        String actualStartDate = startApplicationPage.programStartDate.getText();
        Assert.assertEquals("The start date displayed does not match the expected date for program: "
                + programCode, expectedStartDate, actualStartDate);
    }

    @And("the return policy and the final date for returns should be displayed for {string}")
    public void the_return_policy_and_the_final_date_for_returns_should_be_displayed_for(String programCode) {
        String expectedRefundDate = QaDataReader.getSingleProduct(programCode).getRefundDate();
        BrowserUtils.waitForVisibility(startApplicationPage.refundEndDate, 10);
        String actualRefundDate = startApplicationPage.refundEndDate.getText();
        Assert.assertEquals("Expected refund date does not match actual refund date for program code: "
                + programCode, expectedRefundDate, actualRefundDate);
    }

}
