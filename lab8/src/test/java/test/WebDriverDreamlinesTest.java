package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DreamlinesHomePage;

import java.util.List;


public class WebDriverDreamlinesTest {
    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void commonSearchResultsNotEmpty() {
        int expectedSearchResultsNumber = new DreamlinesHomePage(driver)
                .openPage()
                .searchForTrips()
                .countNumberOfSearchResults();
        Assert.assertTrue(expectedSearchResultsNumber>0, "Search results are empty ");

    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }
}
