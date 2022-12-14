package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OnlineDeals {

    WebDriver driver;
    @FindBy(xpath = "//button[contains(.,'Accept All Cookies')]")
    WebElement Cookies_xpath;
    @FindBy(xpath = "//a[contains(@title,'Personal Site')]")
    WebElement PersonalSite_xpath;

    @FindBy(xpath = "//h4[contains(.,'Shop')]")
    WebElement ShopHeader_xpath;


    @FindBy(xpath = "//span[@class='title'][contains(.,'Samsung Galaxy S22 Plus 5G DS + MS Office 365 Personal')]")
    WebElement DeviceDetails_xpath;

    @FindBy(xpath = "(//div[contains(.,'Samsung Galaxy S22 Plus 5G DS + MS Office 365 Personal')])[10]")
    WebElement SelectedDevice_xpath;

    @FindBy(xpath = "//div[@class='DealDetailFooterTop_details-value__1rON9 col-md-8 col-6'][contains(.,'R818 PM')]")
    WebElement DealPrice_xpath;

    @FindBy(xpath = "//div[@class='DealDetailFooterTop_details-value__1rON9 col-md-8 col-6'][contains(.,'36 months')]")
    WebElement ContractDuration_xpath;

    @FindBy(xpath = "//div[@class='DealDetailFooterTop_details-value__1rON9 col-md-8 col-6'][contains(.,'Yes')]")
    WebElement AvailableOnline_xpath;

    public OnlineDeals(WebDriver driver){this.driver=driver;}

    public OnlineDeals AcceptCookies() {
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(Cookies_xpath));
        Cookies_xpath.click();
        return this;


    }

    public OnlineDeals PageVerify() {
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(PersonalSite_xpath));
        Assert.assertEquals(PersonalSite_xpath.getText(), "Personal");
        return this;
    }

    public void SelectOnlineDeals() {
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(ShopHeader_xpath));
        WebElement mainMenu = driver.findElement(By.xpath(" //h4[contains(.,'Shop')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenu);
        WebElement subMenu = driver.findElement(By.xpath("//a[contains(.,'Online Exclusive Deals')]"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }

    public OnlineDeals selectDevice(){
        new WebDriverWait(driver,50).until(ExpectedConditions.visibilityOf(DeviceDetails_xpath));
        DeviceDetails_xpath.click();
        return this;
    }
    public OnlineDeals validateSelectedDevice() {
        new WebDriverWait(driver,50).until(ExpectedConditions.visibilityOf(SelectedDevice_xpath));
        Assert.assertEquals(SelectedDevice_xpath.getText(), "Samsung Galaxy S22 Plus 5G DS + " +
                "MS Office 365 Personal");
        return this;

    }
    public OnlineDeals dealPrice() {
        Assert.assertEquals(DealPrice_xpath.getText(), "R818 PM");
        return this;

    }
    public OnlineDeals contractDuration() {
        Assert.assertEquals(ContractDuration_xpath.getText(), "36 months");
        return this;

    }
    public OnlineDeals availableOnline() {
        Assert.assertEquals(AvailableOnline_xpath.getText(), "Yes");
        return this;
    }

}
