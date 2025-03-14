package letcode;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
    WebDriver driver;

    public DatePicker() {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://letcode.in/calendar");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void datepicker() {
        try {
        	WebElement d=driver.findElement(By.xpath("//input[@type='date']"));
            d.click();
            d.sendKeys("13/03/2025");
            System.out.println("Selected Date: " + d.getAttribute("value")); // Get input value
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        DatePicker obj = new DatePicker(); 
        obj.datepicker(); 
    }
}
