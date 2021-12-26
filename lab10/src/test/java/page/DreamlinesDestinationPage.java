package page;

import org.openqa.selenium.WebDriver;

public class DreamlinesDestinationPage extends AbstractPage{

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public DreamlinesDestinationPage(WebDriver driver) {
        super(driver);
    }
}

