package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.DreamlinesDestinationPage;
import page.DreamlinesHomePage;

public class DreamlinesHomePageToDestionationsTest  extends CommonConditions {
    private final String url = "https://www.dreamlines.ru/kruiznyye-napravleniya";

    @Test
    public void testClickOnDestinations() throws InterruptedException{
        DreamlinesHomePage homepage = new DreamlinesHomePage(driver);
        homepage.openPage()
                .clickOnDestination();

        DreamlinesDestinationPage destinationpage = new DreamlinesDestinationPage(driver);
        Thread.sleep(2500);
        Assert.assertEquals(destinationpage.getCurrentUrl(), url);
    }
}









