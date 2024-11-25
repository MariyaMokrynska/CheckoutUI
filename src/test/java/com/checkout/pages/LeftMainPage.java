package com.checkout.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftMainPage extends BasePage {

    @FindBy(xpath = "(//img[@src = 'assets/images/logo.svg'])[2]")
    public WebElement sampleAcademyImageAtLeftWindow;

    @FindBy(xpath = "//p[@class='checkout-title']/text()")
    public WebElement secureCheckout;

    @FindBy(xpath = "//a[contains(@href, 'https://sampleacademy.com/')]")
    public List<WebElement> footerElements;

    @FindBy(xpath = "//p[@class='course-name']/a")
    public WebElement programName;



}