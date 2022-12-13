package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSetup {

    private static WebDriver driver = null;

    public static WebDriver startBrowser(String browserchoice,String url){

        if ("chrome".equalsIgnoreCase(browserchoice)){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.addArguments("--disable-notifications");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);

        }else if ("firefox".equalsIgnoreCase(browserchoice)){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }else if ("edge".equalsIgnoreCase(browserchoice)){
            WebDriverManager.edgedriver().setup();

        }else {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);
        return driver;

    }

    public static void teardown(){ driver.quit(); }
}
