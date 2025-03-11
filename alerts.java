package letcode;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alerts {
	
	WebDriver driver;
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/test");
	}

	public void alerts()
	{
		driver.findElement(By.xpath("//a[normalize-space()='Dialog']")).click();
		
		driver.findElement(By.xpath("//button[@id='accept']")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		Alert dismiss=driver.switchTo().alert();
		dismiss.dismiss();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		alerts obj=new alerts();
		obj.setup();
		obj.alerts();
	}

}
