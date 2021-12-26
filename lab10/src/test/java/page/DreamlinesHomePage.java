package page;

import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waits;

import java.nio.charset.StandardCharsets;


public class DreamlinesHomePage extends AbstractPage {

    private static final Logger logger = LogManager.getRootLogger();
    private static final String HOMEPAGE_URL = "https://www.dreamlines.ru/";
    private static final String SEARCH_BUTTON_XPATH = "//*[@id=\"searchForm\"]/div/div[5]/button";
    private static final String SUBSCRIBE_BUTTON_XPATH = "//*[@id=\"footer_newsletter_button\"]";
    private static final String ERROR_MESSAGE_XPATH = "//*[@id=\"footer_getInContact_switch\"]//div[@data-test-id=\"newsletterMessage\"]";
    private JavascriptExecutor js=(JavascriptExecutor) driver;
    private By Destination=By.xpath("//*[@id=\"mainmenu_destinations\"]");

    @FindBy(xpath=SEARCH_BUTTON_XPATH)
    private WebElement searchButton;

    @FindBy (xpath = SUBSCRIBE_BUTTON_XPATH)
    private WebElement subscribeButton;

    public DreamlinesHomePage(WebDriver driver){
        super(driver);
    }

    public DreamlinesHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        logger.info("Home page opened");
        return this;
    }

    public DreamlinesHomePage clickOnSubscribeButton() {
        js.executeScript("arguments[0].click();",subscribeButton);
        logger.info("Click");
        return this;
    }

    public DreamlinesHomePage clickOnDestination(){
        findElementAndClick(Destination);
        logger.info("Click on destination");
        return this;
    }

    public String getErrorMessage(){
        //Waits.isElementAttributeNotEmpty(driver, "style", driver.findElement(By.xpath(ERROR_MESSAGE_XPATH)));
        return new String(
                ((String)js.executeScript("return arguments[0].innerHTML;",
                        driver.findElement(By.xpath(ERROR_MESSAGE_XPATH))))
                        .getBytes(StandardCharsets.UTF_8));

    }

}
