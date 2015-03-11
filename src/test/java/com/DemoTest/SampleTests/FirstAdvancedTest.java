package com.DemoTest.SampleTests;

import com.DemoTest.DSL.GoogleSearchMainPage;
import com.DemoTest.Naming.EnvSpecificPaths;
import com.DemoTest.Naming.GuiBindings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This is a simple functional tests using selenium/java/maven
 * It uses page objects model and an extension - page as a service
 * Created by acorha
 */
public class FirstAdvancedTest {

    @Test
    public void startWebDriver(){

        System.setProperty("webdriver.chrome.driver", EnvSpecificPaths.CHROME_DRIVER_PATH);

        //get a driver instance
        WebDriver driver = new ChromeDriver();

        //navigate to www.google.ro web page
        driver.navigate().to(GuiBindings.GOOGLE_PAGE_LOCATION);

        //Instantiate the page
        GoogleSearchMainPage mainPage = new GoogleSearchMainPage(driver);

        //Verify a page service - verify is the search box is ready
        //Check once 500ms for 10s
        Assert.assertTrue("The search text box should be displayed and enabled", mainPage.waitUntilThePageIsLoaded(10000, 500));

        //Enter some text in the search box
        GoogleSearchMainPage mainPageAfterSearch = mainPage.searchText(GuiBindings.GOOGLE_SEARCH_TEXT);

        Assert.assertTrue("The page should be loaded after doing the search", mainPageAfterSearch.waitUntilThePageIsLoaded(10000, 500));

        //end the test properly
        driver.close();
        driver.quit();
    }
}
