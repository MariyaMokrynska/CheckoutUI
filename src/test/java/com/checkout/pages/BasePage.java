package com.checkout.pages;

import com.checkout.utilities.DriverUtils;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverUtils.getDriver(), this);
    }


    public void logIn(String programCode){
        String url = "https://" + System.getenv("username") + ":" + System.getenv("password")
                + "@qa.sampleacademy.demo.com/" + programCode;
        DriverUtils.getDriver().get(url);

    }

}
