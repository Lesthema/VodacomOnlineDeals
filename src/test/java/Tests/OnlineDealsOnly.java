package Tests;

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
}
