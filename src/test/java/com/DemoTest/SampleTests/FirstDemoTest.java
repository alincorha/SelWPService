package com.DemoTest.SampleTests;

import com.DemoTest.Naming.EnvSpecificPaths;
import com.DemoTest.Naming.GuiBindings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This is a simple functional tests using selenium/java/maven
 * Created by acorha
 */
public class FirstDemoTest {

    @Test
    public void startWebDriver(){

        System.setProperty("webdriver.chrome.driver", EnvSpecificPaths.CHROME_DRIVER_PATH);

        //get a driver instance
        WebDriver driver = new ChromeDriver();

        //navigate to www.google.ro web page
        driver.navigate().to(GuiBindings.GOOGLE_PAGE_LOCATION);

        //assert page title
        Assert.assertTrue("Page title should be: " + GuiBindings.GOOGLE_PAGE_NAME, driver.getTitle().equalsIgnoreCase(GuiBindings.GOOGLE_PAGE_NAME));

        //end the test properly
        driver.close();
        driver.quit();
    }
}
