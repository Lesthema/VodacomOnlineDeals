package Tests;

import PageObjects.*;
import Utils.BrowserSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BaseTests {

    BrowserSetup StartBrowser = new BrowserSetup();

    final WebDriver driver = StartBrowser.startBrowser("chrome", "https://www.vodacom.co.za/ ");
    OnlineDeals onlineDeals = PageFactory.initElements(driver, OnlineDeals.class);

}