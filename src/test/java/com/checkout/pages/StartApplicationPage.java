package com.checkout.pages;

import com.checkout.utilities.BrowserUtils;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;
import java.util.HashMap;
import java.util.Map;


public class StartApplicationPage extends BasePage {

    @FindBy(xpath = "(//div[@class = 'step-title'])[1]")
    public WebElement startApplicationText;

    @FindBy(xpath = "(//div[@class = 'step-title'])[2]")
    public WebElement paymentPlanText;

    @FindBy(xpath = "(//div[@class = 'step-title'])[3]")
    public WebElement reviewText;

    @FindBy(xpath = "(//*[@class='step-circle'])[1]")
    public WebElement startApplicationStepCircle;

    @FindBy(xpath = "(//*[@class='step-circle'])[2]")
    public WebElement paymentPlanStepCircle;

    @FindBy(xpath = "(//*[@class='step-circle'])[3]")
    public WebElement reviewStepCircle;

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    public WebElement firstNameInputBox;
  
    @FindBy(xpath = "//mat-label[.='First Name']")
    public WebElement firstNameLabel;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    public WebElement lastNameInputBox;
  
    @FindBy(xpath = "//mat-label[.='Last Name']")
    public WebElement lastNameLabel;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    public WebElement emailInputBox;
  
    @FindBy(xpath = "//mat-label[.='Email Address']")
    public WebElement emailLabel;

    @FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
    public WebElement phoneNumberInputBox;

    @FindBy(xpath = "//mat-label[.='Phone']")
    public WebElement phoneLabel;

    @FindBy(xpath = "//mat-label[text()='How did you hear about us?']")
    public WebElement howDidYouHearAboutUsDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Email')]")
    public WebElement emailOptionFromDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Facebook')]")
    public WebElement facebookOptionFromDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Google')]")
    public WebElement googleOption;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Instagram')]")
    public WebElement instagramOptionFromDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'LinkedIN')]")
    public WebElement linkedInOptionFromDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Twitter')]")
    public WebElement twitterOptionFromDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Referred by a friend')]")
    public WebElement referredByFriedOptionFromDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Other')]")
    public WebElement otherOptionFromDropDown;

    @FindBy(xpath = "//p[text() = 'Flexible payments plan available']")
    public WebElement flexiblePaymentsPlanAvailableText;

    @FindBy(xpath = "//div[contains(text(), 'Program Start Date')]/b[@class='info-value']")
    public WebElement programStartDate;

    @FindBy(xpath = "(//b[@class='info-value'])[2]")
    public WebElement refundEndDate;

    @FindBy(xpath = "//p[@class='program-title primary-color']")
    public WebElement programNameOnInfoCard;

    @FindBy(xpath = "//div[@class='col-sm']/b[@class = 'info-primary']")
    public WebElement programPrice;

    @FindBy(xpath = "//s[contains(text(), '$')]")
    public WebElement originalPrice;

    @FindBy(xpath = "//b[@class='info-primary' and contains(text(), '$400')]")
    public WebElement fwdpPrice;

    @FindBy(xpath = "//p[@class = 'footer-text' and contains(text(), 'Need help?')]")
    public WebElement footer;

    @FindBy(xpath = "//button[@class = 'next-button'][contains(text(), 'Next')]")
    public WebElement nextButton;

    @FindBy(xpath = "//*[@id=\"mat-input-4\"]")
    public WebElement parentFirstNameInputBox;

    @FindBy(xpath = "//*[@id=\"mat-input-5\"]")
    public WebElement parentLastNameInputBox;

    @FindBy(xpath = "//*[@id=\"mat-input-6\"]")
    public WebElement parentAddressInputBox;

    @FindBy(xpath = "//*[@id=\"mat-input-7\"]")
    public WebElement parentPhoneNumberInputBox;

    @FindBy(className = "checkout-title")
    public WebElement secureCheckoutText;

    @FindBy(className = "course-name")
    public WebElement programTitle;

    @FindBy(css = ".footer-left-side .footer-item")
    public List<WebElement> leftSidefooterElements;

    @FindBy(xpath = "//div[@class='form details-form']//p[@class='footer-text'][normalize-space()='Need help? Contact us at sampleacademy.com']")
    public WebElement rightFooterContactInfo;

    @FindBy(xpath = "(//mat-label[.='First Name'])[2]")
    public WebElement parentFirstNameLabel;

    @FindBy(xpath = "(//mat-label[.='Last Name'])[2]")
    public WebElement parentLastNameLabel;

    @FindBy(xpath = "(//mat-label[.='Email Address'])[2]")
    public WebElement parentEmailLabel;

    @FindBy(xpath = "(//mat-label[.='Phone'])[2]")
    public WebElement parentPhoneLabel;



    public void fillParentInformation() {
        BrowserUtils.waitForVisibility(parentFirstNameInputBox, 10);
        parentFirstNameInputBox.clear();
        parentFirstNameInputBox.sendKeys("John");

        BrowserUtils.waitForVisibility(parentLastNameInputBox, 10);
        parentLastNameInputBox.clear();
        parentLastNameInputBox.sendKeys("Doe");

        BrowserUtils.waitForVisibility(parentAddressInputBox, 10);
        parentAddressInputBox.clear();
        parentAddressInputBox.sendKeys("johndoe@gmail.com");

        BrowserUtils.waitForVisibility(parentPhoneNumberInputBox, 10);
        parentPhoneNumberInputBox.clear();
        parentPhoneNumberInputBox.sendKeys("0987654321");

    }
  
      public Map<String, String> getUserFields() {
        Map<String, String> userFields = new HashMap<>();
        userFields.put("firstName", firstNameInputBox.getAttribute("value"));
        userFields.put("lastName", lastNameInputBox.getAttribute("value"));
        userFields.put("email", emailInputBox.getAttribute("value"));
        userFields.put("phoneNumber", phoneNumberInputBox.getAttribute("value"));
        return userFields;
    }

    /**
 * This function checks the color of a given WebElement and asserts if it is red.
 *
 * @param element The WebElement to check the color of. It is expected to be a label element.
 *
 * @return void This function does not return any value. It performs an assertion to check the color.
 *
 * @throws AssertionError If the color of the element is not red.
 *
 * @throws Exception If any other exception occurs during the execution of the function.
 */
public void checkTheColor(WebElement element) {
    // Get the color of the label
    String colorValue = element.getCssValue("color");
    Color color = Color.fromString(colorValue);
    // Assert that the color is red
    Assert.assertEquals("Label should be red", "#ff0000", color.asHex());
}

    /**
 * This function checks the validity and content of a phone number input field.
 * It simulates user input and verifies the field's behavior based on the input.
 *
 * @param webElement The WebElement representing the phone number input field.
 *
 * @return void This function does not return any value. It performs assertions to validate the input.
 *
 * @throws AssertionError If any of the assertions fail.
 *
 * @throws Exception If any other exception occurs during the execution of the function.
 */
public void checkThePhoneNumber(WebElement webElement) {
    try {
        webElement.sendKeys("12345");
        assertEquals("12345", webElement.getAttribute("value"));
        webElement.clear();
        webElement.sendKeys("123abc456");

        String fieldValue = webElement.getAttribute("value");
        assertTrue("Field should only contain numbers", fieldValue.matches("^[0-9]*$"));
        assertNotEquals("123abc456", fieldValue);

        webElement.clear();
        webElement.sendKeys("123!@#456");

        fieldValue = webElement.getAttribute("value");
        assertTrue("Field should only contain numbers", fieldValue.matches("^[0-9]*$"));
        assertNotEquals("123!@#456", fieldValue);

    } catch (AssertionError e) {
        System.out.println("Assertion failed: " + e.getMessage());

    } catch (Exception e) {
        System.out.println("An exception occurred: " + e.getMessage());

    }
}

}
