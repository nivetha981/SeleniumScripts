package letcode;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsTest {

    private WebDriver driver;

    public AlertsTest() {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
        driver.get("https://letcode.in/test");
    }

    public void handleAlerts() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10); 
            driver.findElement(By.xpath("//a[normalize-space()='Dialog']")).click();

            driver.findElement(By.xpath("//button[@id='accept']")).click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("Alert accepted");

            driver.findElement(By.xpath("//button[@id='confirm']")).click();
            Alert dismissAlert = driver.switchTo().alert();
            dismissAlert.dismiss();
            System.out.println("Alert dismissed");

            driver.findElement(By.xpath("//button[@id='prompt']")).click();
            Alert promptAlert = driver.switchTo().alert();
            promptAlert.sendKeys("Nivi");
            promptAlert.accept();
            System.out.println("Prompt alert sent");

            driver.findElement(By.xpath("//button[@id='modern']")).click();
            driver.findElement(By.xpath("//button[@aria-label='close']")).click();
            System.out.println("Sweet alert dismissed");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed");
            }
        }
    }

    public static void main(String[] args) {
        AlertsTest obj = new AlertsTest();
        obj.handleAlerts();
    }
}
