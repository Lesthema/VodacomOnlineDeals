package Tests;

import Utils.BrowserSetup;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class OnlineDealsOnly extends BaseTests{

      public void deals() {
        onlineDeals
                .AcceptCookies()
                .PageVerify()
                .SelectOnlineDeals();
        onlineDeals
                .selectDevice();
        onlineDeals
                .validateSelectedDevice()
                .dealPrice()
                .contractDuration()
                .availableOnline();
    }
    @Test(dependsOnMethods = "deals")
    public void dealError() {
        onlineDeals
                .AcceptCookies()
                .PageVerify()
                .SelectOnlineDeals();
        onlineDeals
                .selectDevice();
        onlineDeals
                .validateSelectedDevice()
                .InvalidDealPrice()
                .contractDuration()
                .availableOnline();
    }
    @AfterTest
    public void closeBrowser(){ BrowserSetup.teardown();}
}
