package com.checkout.step_definition;

import com.checkout.pages.PaymentPlanPage;
import com.checkout.utilities.BrowserUtils;
import com.checkout.utilities.QaDataReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ViewDetailedPriceSummary {

    public PaymentPlanPage paymentPlanPage = new PaymentPlanPage();


    @When("the user clicks on any accordion, it should expand to open the price details")
    public void the_user_clicks_on_any_accordion_it_should_expand_to_open_the_price_details() {

        paymentPlanPage.topPaymentFrame.click();
        BrowserUtils.waitFor(1);

        Assert.assertEquals("Expected true as attribute value confirming the accordion expansion!",
                "true", paymentPlanPage.topPaymentFrame.getAttribute("aria-expanded"));
    }


    @Then("Price details for each price type follow the test-data in provided json {string}")
    public void price_details_for_each_price_type_follow_the_test_data_in_provided_json(String arg) {

        String actualBasePrice = paymentPlanPage.basePriceOfFirstPaymentOption.getText();
        int actualBaseAmount = Integer.parseInt(actualBasePrice.replace("$", "").trim());
        int expectedBaseAmount = QaDataReader.getBaseAmount(arg);

        Assert.assertEquals("Expected base amount : " + expectedBaseAmount + "!",
                expectedBaseAmount, actualBaseAmount);
    }


    @Then("Each price summary must say excluding fees at the end")
    public void each_price_summary_must_say_excluding_fees_at_the_end() {

        Assert.assertTrue(paymentPlanPage.excludingFeesTextUnderFirstPaymentOption.isDisplayed());
    }


}
