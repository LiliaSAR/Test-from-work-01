package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract String getUrl();

    public void type(WebElement element, String text) {
        System.out.println("Typing" + text + "to element with location" + element.toString());
        element.sendKeys(text);
    }

    public void type(By location, String text) {

        type(find(location), text);
    }

    public void type(String cssSelector, String text) {
        type(By.cssSelector(cssSelector), text);
    }

    public WebElement find(By location) {
        return driver.findElement(location);
    }

    public List<WebElement> findElements(By location) {
        return driver.findElements(location);
    }

    public void click(WebElement element) {
        System.out.println("Cliking onelement with location" + element.toString());
        element.click();
    }

    public void click(By location) {

        click(find(location));
    }

    public boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

}
