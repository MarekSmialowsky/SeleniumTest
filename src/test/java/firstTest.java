import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class firstTest {


    @Test
    public void openGooglePage() {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        agreeButton.click();
        driver.switchTo().defaultContent();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("selenium");
        searchField.sendKeys(Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));

        Assert.assertTrue(result.isDisplayed());



    }

    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
            //   String chromePath = "C:\\Users\\sieci\\OneDrive\\Desktop\\tutorialselenium\\chromedriver.exe";
            //   System.setProperty("webdriver.chrome.driver", chromePath);
                return new ChromeDriver();
            case "firefox":
            //    String firefoxPath = "C:\\Users\\sieci\\OneDrive\\Desktop\\tutorialselenium\\geckodriver.exe";
            //    System.setProperty("webdriver.gecko.driver", firefoxPath);
                return new FirefoxDriver();
            default:
                throw new InvalidArgumentException("Invalid browser name");
        }

   /* public WebDriver getDriver (String browser){
        if (browser.equals("chrome")){
            String chromePath = "C:\\Users\\sieci\\OneDrive\\Desktop\\tutorialselenium\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromePath);
            return new ChromeDriver();
        }else if (browser.equals("firefox")){
            String firefoxPath = "C:\\Users\\sieci\\OneDrive\\Desktop\\tutorialselenium\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", firefoxPath);
            return new FirefoxDriver();
        }
        else  throw new InvalidArgumentException("Invalid browser name"); */
    }

}
