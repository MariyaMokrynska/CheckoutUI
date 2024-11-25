package com.checkout.step_definition;

import com.checkout.pages.PaymentPlanPage;
import com.checkout.pages.StartApplicationPage;
import com.checkout.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;


public class ProgramsWithOneTimeDiscounts {
    private StartApplicationPage startApplicationPage;
    private PaymentPlanPage paymentPlanPage;

    public ProgramsWithOneTimeDiscounts(){
        this.startApplicationPage = new StartApplicationPage();
        this.paymentPlanPage = new PaymentPlanPage();
    }

    @Then("the full price should be displayed with a strike-through")
    public void the_full_price_should_be_displayed_with_a_strike_through() {
        WebElement strikeThrough = startApplicationPage.programPrice.findElement(By.xpath("following-sibling::span/s"));
        BrowserUtils.waitForVisibility(strikeThrough, 10);
        boolean isStrikeThroughDisplayed = strikeThrough.isDisplayed();
        Assert.assertTrue("The strike-through price should be displayed.", isStrikeThroughDisplayed);
    }
    @Then("the discounted price should be shown in blue")
    public void the_discounted_price_should_be_shown_in_blue() {
        BrowserUtils.waitForVisibility(startApplicationPage.programPrice, 10);
        String color = startApplicationPage.programPrice.getCssValue("color");
        String hexColor = Color.fromString(color).asHex();
        Assert.assertEquals("The discounted price color is blue.", "#1f8fff", hexColor);
    }
    @Then("the discount amount should be displayed on a green badge")
    public void the_discount_amount_should_be_displayed_on_a_green_badge() {
        BrowserUtils.waitForVisibility(paymentPlanPage.discountBadgeElement, 10);
        String backgroundColor = paymentPlanPage.discountBadgeElement.getCssValue("background-color");
        String hexColor = Color.fromString(backgroundColor).asHex();
        Assert.assertEquals("Badge background color should be green", "#cdf8b8", hexColor);
    }
    @Then("the badge text should read: {string}")
    public void the_badge_text_should_read(String expectedText) {
        BrowserUtils.waitForVisibility(paymentPlanPage.greenBadgeTextUpfrontDiscount, 10);
        String actualText = paymentPlanPage.greenBadgeTextUpfrontDiscount.getText().trim();
        String badgeText = actualText.substring(actualText.indexOf("$")).trim();
        Assert.assertEquals("Badge text should match {$<discount_amount> Upfront discount} format", expectedText, badgeText );
    }
}
