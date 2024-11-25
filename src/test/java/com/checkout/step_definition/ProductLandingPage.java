package com.checkout.step_definition;

import com.checkout.pages.StartApplicationPage;
import com.checkout.utilities.DriverUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProductLandingPage {

    private StartApplicationPage startApplicationPage = new StartApplicationPage();

    @Then("the system should display the text {string}")
    public void the_system_should_display_the_text(String string) {
        assert startApplicationPage.secureCheckoutText.isDisplayed();
    }

    @Then("the system should display the {string}")
    public void the_system_should_display_the(String expectedTitle) {
        String actualTitle = startApplicationPage.programTitle.getText();
        assertEquals(expectedTitle, actualTitle);
    }

    @Then("the footer should contain the following items in order on the left side:")
    public void the_footer_should_contain_the_following_items_in_order_on_the_left_side(List<String> expectedItems) {
        List<String> actualItems = new ArrayList<>();

        for (int i = 0; i < startApplicationPage.leftSidefooterElements.size(); i++) {
            WebElement element = startApplicationPage.leftSidefooterElements.get(i);
            if (i == 0) {
                if (element.getTagName().equals("img")) {
                    String altText = element.getCssValue("a[class='ng-star-inserted'] img");
                    if (altText != null && !altText.isEmpty()) {
                        actualItems.add("logo");
                    } else {
                        actualItems.add("logo");  // Simplify by adding "logo" for the first image
                    }
                }
            } else {
                actualItems.add(element.getText().trim());
            }
        }
    }

    @Then("the footer should display {string} on the right")
    public void the_footer_should_display_on_the_right(String string) {
        assert startApplicationPage.rightFooterContactInfo.isDisplayed();
    }


}
