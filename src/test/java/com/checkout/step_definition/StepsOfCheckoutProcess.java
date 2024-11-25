package com.checkout.step_definition;

import com.checkout.pages.StartApplicationPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import java.util.List;
import java.util.Map;
public class StepsOfCheckoutProcess {
    private StartApplicationPage startApplicationPage = new StartApplicationPage();

    @Then("the system should display the steps of the checkout process as:")
    public void the_system_should_display_the_steps_of_the_checkout_process_as(List<Map<String, String>> stepsList) {
        for (Map<String, String> step : stepsList) {
            String stepNumber = step.get("Step Number");
            String stepName = step.get("Step Name");

            switch (stepNumber) {
                case "1":
                    Assert.assertEquals(stepNumber, startApplicationPage.startApplicationStepCircle.findElement(By.tagName("span")).getText().trim());
                    Assert.assertEquals(stepName, startApplicationPage.startApplicationText.getText().trim());
                    break;
                case "2":
                    Assert.assertEquals(stepNumber, startApplicationPage.paymentPlanStepCircle.findElement(By.tagName("span")).getText().trim());
                    Assert.assertEquals(stepName, startApplicationPage.paymentPlanText.getText().trim());
                    break;
                case "3":
                    Assert.assertEquals(stepNumber, startApplicationPage.reviewStepCircle.findElement(By.tagName("span")).getText().trim());
                    Assert.assertEquals(stepName, startApplicationPage.reviewText.getText().trim());
                    break;
            }
        }
    }

    @Then("the system should highlight the {string} step in blue")
    public void the_system_should_highlight_the_step_in_blue(String step) {
        if (step.equals("Start Application")) {
            String color = startApplicationPage.startApplicationStepCircle.getCssValue("background-color");
            Assert.assertEquals("Expected blue color", "#01c9ff", Color.fromString(color).asHex());
        }
    }

    @Then("the system should display {string} and {string} steps with no color")
    public void the_system_should_display_and_steps_with_no_color(String step1, String step2) {
        if (step1.equals("Payment plan")) {
            String color1 = startApplicationPage.paymentPlanStepCircle.getCssValue("background-color");
            Assert.assertEquals("Expected no color for Payment plan", "#000000", Color.fromString(color1).asHex());
        }
        if (step2.equals("Review")) {
            String color2 = startApplicationPage.reviewStepCircle.getCssValue("background-color");
            Assert.assertEquals("Expected no color for Review", "#000000", Color.fromString(color2).asHex());
        }
    }
}
