package com.checkout.utilities;

import com.checkout.utilities.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * This class provides utility methods for managing web drivers.
 */
public class DriverUtils {

    private DriverUtils(){}

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();;

    /**
     * Returns the WebDriver instance for the current thread. If no WebDriver instance exists for the current thread, a new instance is created based on the browser type specified in the configuration file.
     * @return the WebDriver instance for the current thread
     */
    public static WebDriver getDriver(){

        if(driverPool.get() == null){
            String browserType = ConfigurationReader.getConfigProperty("browser").toLowerCase();
            switch (browserType){
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-search-engine-choice-screen");
                    driverPool.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
            }

        }

        return driverPool.get();

    }


    /**
     * Closes the WebDriver instance for the current thread.
     */
    public static void closeDriver(){
        if (driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }



}
