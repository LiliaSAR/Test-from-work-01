import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SeleniumTest {
    private WebDriver driver;


    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver-windows-32bit.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void successLogin()
    {
        driver.get("https://www.google.com/");
        assertTrue(driver.getCurrentUrl().contains("https://www.google.com/"),"The page is not load corrency");
    }

    @Test
    public void githubFailedLogin()
    {
        LoginPage loginPage =  new LoginPage(driver);

        assertFalse(loginPage.isErrorMessageDisplayed(),"Error mesage is not displayed");
        loginPage.loginWith("mail@mail.am", "Password");

        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message was not displayed!");
    }


    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}