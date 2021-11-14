package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DreamlinesHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.dreamlines.ru/";
    private static final String SEARCH_BUTTON_XPATH = "//*[@id=\"searchForm\"]/div/div[5]/button";

    @FindBy(xpath=SEARCH_BUTTON_XPATH)
    private WebElement searchButton;

    public DreamlinesHomePage(WebDriver driver){
        super(driver);
    }

    public DreamlinesHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public DreamlinesResultPage searchForTrips(){
        searchButton.click();
        return new DreamlinesResultPage(driver);
    }
}
