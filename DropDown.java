package letcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class DropDown {

    WebDriver driver;

    public DropDown() {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/test");
    }

    public void dropdown() {
        try {
            driver.findElement(By.xpath("//a[normalize-space()='Drop-Down']")).click();

            WebElement fruitDropdown = driver.findElement(By.id("fruits"));
            Select fruitSelect = new Select(fruitDropdown);
            fruitSelect.selectByVisibleText("Orange");

            WebElement heroDropdown = driver.findElement(By.id("superheros"));
            Select heroSelect = new Select(heroDropdown);
            heroSelect.selectByVisibleText("Captain America");

            WebElement langDropdown = driver.findElement(By.id("lang"));
            Select langSelect = new Select(langDropdown);
            langSelect.selectByValue("sharp");

            List<WebElement> allOptions = langSelect.getOptions();
            System.out.print("All available language options: ");
            for (WebElement option : allOptions) {
                System.out.print(option.getText() + ", ");
            }
            System.out.println();

            WebElement countryDropdown = driver.findElement(By.id("country"));
            Select countrySelect = new Select(countryDropdown);
            countrySelect.selectByVisibleText("India");

            WebElement selectedOption = countrySelect.getFirstSelectedOption();
            System.out.println("Selected country: " + selectedOption.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }

    public static void main(String[] args) {
        DropDown obj = new DropDown(); 
        obj.dropdown();
    }
}
