import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SeleniumTest {
    private WebDriver driver;


    @Test
    public void successLogin()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lilias\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        assertTrue(driver.getCurrentUrl().contains("https://www.google.com/"),"The page is not load corrency");

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}