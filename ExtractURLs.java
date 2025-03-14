package letcode;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtractURLs {
    
    WebDriver driver;

    public ExtractURLs() {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.irctc.co.in/nget/train-search"); // Change this URL as needed
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void extractAllLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Total links found: " + links.size());
        
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            String text = link.getText();

            if (url != null && !url.isEmpty()) {
                System.out.println("Text: " + (text.isEmpty() ? "[No Text]" : text));
                System.out.println("URL: " + url);
                System.out.println("----------------------");
            }
        }
    }

    public static void main(String[] args) {
        ExtractURLs obj = new ExtractURLs();
        obj.extractAllLinks();
        obj.driver.quit(); 
    }
}
