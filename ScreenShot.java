package letcode;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

				// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
				ChromeDriver driver1=new ChromeDriver();
				driver1.get("https://letcode.in/button");
				driver1.manage().window().maximize();

				//page s.s
				File scr=driver1.getScreenshotAs(OutputType.FILE);
				File dest=new File("./snap/img1.png");
				FileHandler.copy(scr,dest);
				//element.ss 
				// Element screenshot (corrected)
				WebElement ele = driver1.findElement(By.xpath("//button[@id='home']"));
				File scr1 = ele.getScreenshotAs(OutputType.FILE); // Take screenshot of the element
				File loc = new File("./snap/img2.png");
				FileHandler.copy(scr1, loc);

				//section.s.s
				WebElement d=driver1.findElementByClassName("content");
				File scr2=d.getScreenshotAs(OutputType.FILE);
				File dest2=new File("./snap/img3.png");
				FileHandler.copy(scr2,dest2);
				driver1.quit();
			}

		
	}


