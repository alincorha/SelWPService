package com.DemoTest.DSL;

import com.DemoTest.Naming.GuiBindings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page extends the WebPageBase abstract class
 * 'Page as a service' model - this page is fully loaded when the search box is visible and enabled
 * Created by acorha
 */
public class GoogleSearchMainPage extends WebPageBase {

    private final WebDriver driver;

    //Constructor
    public GoogleSearchMainPage(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        if (!GuiBindings.GOOGLE_PAGE_NAME.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }
    }

    // search box web element
    By searchBox = By.name(GuiBindings.GOOGLE_SEARCH_BOX_NAME);

    //'Page as a service' model - the search box should allow the user to type some text
    public GoogleSearchMainPage searchText(String text) {
        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(searchBox).submit();
        return new GoogleSearchMainPage(driver);
    }

    // 'Page as a service' model - the page is fully loaded when the search box is displayed and enabled
    @Override
    public boolean waitUntilThePageIsLoaded(long time, long period) {

        for (int count = 0; count < time; count += period) {
            if (driver.findElement(searchBox).isEnabled() && driver.findElement(searchBox).isDisplayed()) {
                return true;
            }
            try {
                Thread.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
