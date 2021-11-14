package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DreamlinesResultPage extends AbstractPage{

    private static final String RESULTS_XPATH = "//div[contains(@class, 'search-result-item')]";

    @FindBy(xpath=RESULTS_XPATH)
    private List<WebElement> searchResults;

    public DreamlinesResultPage(WebDriver driver){
        super(driver);
    }

    public int countNumberOfSearchResults(){
       return searchResults.size();
    }

    @Override
    protected AbstractPage openPage(){
        throw new RuntimeException("");
    }
}
