package letcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	WebDriver driver;
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/test");
	}
	
	public void dropdown()
	{
		driver.findElement(By.xpath("//a[normalize-space()='Drop-Down']")).click();	
		WebElement dropdown=driver.findElement(By.id("fruits"));
		Select drop=new Select(dropdown);
		drop.selectByVisibleText("Orange");
		
		WebElement dropdown2=driver.findElement(By.id("superheros"));
		Select drop2=new Select(dropdown2);
		drop2.selectByVisibleText("Captain America");
		
		WebElement drop3=driver.findElement(By.id("lang"));
		Select dropp3=new Select(drop3);
		dropp3.selectByValue("sharp");
		System.out.println("all options"+drop3.getText());
		
		WebElement drop4=driver.findElement(By.id("country"));
		Select text=new Select(drop4);
		text.selectByVisibleText("India");
        WebElement selectedOption = text.getFirstSelectedOption();
		System.out.println("selcted option is "+selectedOption.getText());
		
	}
	void teardown()
	{
		driver.quit();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DropDown obj=new DropDown();
		obj.setup();
		obj.dropdown();
		obj.teardown();

	}

}
