import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {

    @Test
    public void performAction(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");
// znalezienie elementu i jego kliknięcie
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        basicPageLink.click();
        //driver.findElement(By.id("clickOnMe")).click();
        driver.findElement(By.id("fname")).click();
// wyczyszczenie elementu input i wprowadzenie wartości do niego
        WebElement firstName = driver.findElement(By.id("fname"));
        firstName.sendKeys("Przemek");
        firstName.clear();

        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.clear();
        userNameInput.sendKeys("Nowa nazwa użytkownika");
// pobranie wartości z pola tekstowego (input)
        userNameInput.getAttribute("value");
// pobranie wartości z ukrytego elementu
        WebElement parag = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println(parag.getAttribute("textContent"));

// sumulacja klawiatury w selenium
        userNameInput.sendKeys(Keys.ENTER);
// obsługa alertów
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        driver.switchTo().alert().accept();

// zaznaczenie checkbox i radio button
        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();
// wybranie elementu z selektora
        WebElement selektCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selektCar);
        cars.selectByVisibleText("Volvo");

        List<WebElement> options = cars.getOptions();
        for (WebElement option : options){
            System.out.println(option.getText());
        }

        HomeworkSelectCheck selectCheck = new HomeworkSelectCheck();
        System.out.println(selectCheck.checkOption("Audi", selektCar));
        System.out.println(selectCheck.checkOption("Fiat", selektCar));
    }
}
