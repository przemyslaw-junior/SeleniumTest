import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {
    @Test
    public void testNewWindow (){
// otwarcie strony głównej
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
// pobranie nazwy strony głównej
        String currentWindow = driver.getWindowHandle();
// przejście na strone po wciśnięciu przycisku "click me"
        driver.findElement(By.id("newPage")).click();
// stworzenie zbioru z nazwami stron i przepięciu się na nową strone
        Set<String> windowNames = driver.getWindowHandles();
        for (String window : windowNames){
// jeżeli strona nie jest równa stronie łównej
            if (!window.equals(currentWindow)){
                driver.switchTo().window(window);
            }
        }
// przepięcie się na popup z ciasteczkami i zaakceptowanie ich
        WebElement agreeButton = driver.findElement(By.xpath("//div[contains(text(),'Zgadzam')]"));
        agreeButton.click();
// wpisanie elementu w pole wyszukiwania
        driver.findElement(By.name("q")).sendKeys("Selenium");
// powrót na strone główną
        driver.switchTo().window(currentWindow);
// wpisanie elementu w inputa
        driver.findElement(By.name("fname")).sendKeys("Przemek");
    }
}
