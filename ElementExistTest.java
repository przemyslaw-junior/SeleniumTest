import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.print.DocFlavor;

public class ElementExistTest {

    WebDriver driver;

    @Test
    public void elementExistTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        System.out.println("element hidden istnieje "+ elementExist(By.tagName("p")));
        System.out.println("element hidden nie istnieje z metodą id "+ elementExist(By.id("topSecret")));

        System.out.println("element hidden istnieje na liście "+ elementExistList(By.tagName("p")));
        System.out.println("element hidden nie istnieje na liscie z metodą id "+elementExistList(By.id("topSecret")));

// czy Element jest widoczny na stronie
        System.out.println("widoczny etement "+ driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println("widoczny etement "+ driver.findElement(By.tagName("button")).isDisplayed());

// dopisanie disabled/wyszażenie w strukturze html
        driver.findElement(By.xpath("//button[@type= 'button']"));

        WebElement checkbox = driver.findElement(By.xpath("//input[@type= 'checkbox']"));
        System.out.println("czy check box nie jest zaznaczony "+ checkbox.isSelected());
        checkbox.click();
        System.out.println("czy check box jest zaznaczony "+ checkbox.isSelected());

    }

    public boolean elementExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    public boolean elementExistList(By locator){
            return  driver.findElements(locator).size()>0;
    }

}
