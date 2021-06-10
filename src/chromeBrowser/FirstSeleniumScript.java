package chromeBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstSeleniumScript {

	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (2)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		System.out.println("url opened");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void login() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("akhu@xyz.com");
		driver.findElement(By.xpath("//button[@class='btn btn-default button button-medium exclusive']")).click();
		
		//radio
		WebElement radiobutton=driver.findElement(By.id("id_gender2"));
		radiobutton.click();
		
		//text
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("akshu");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("n");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("akshu@123");
		
		//dropdown
		Select select= new Select(driver.findElement(By.id("days")));
		select.selectByVisibleText("18  ");
		
		Select select1= new Select(driver.findElement(By.xpath("//*[@id='uniform-months']/select[@id='months']")));
		select1.selectByVisibleText("March ");
		Select select2= new Select(driver.findElement(By.id("years")));
		select2.selectByVisibleText("2000  ");
		
		
		//chckbox
		WebElement chckbox= driver.findElement(By.id("newsletter"));
		for(int i=0;i<2;i++)
		{
			chckbox.click();
			System.out.println(chckbox.isSelected());
		}
		
		
		WebElement name=driver.findElement(By.xpath("//*[@id='firstname']"));
		name.clear();
		name.sendKeys("akshu");
		
		WebElement lname=driver.findElement(By.xpath("//*[@id='lastname']"));
		
		name.clear();
		name.sendKeys("nv");
						driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("newyork");
								driver.findElement(By.xpath("//*[@id='city']")).sendKeys("somecity");
								
										Select selectcity=new Select(driver.findElement(By.xpath("//div/select[@id='id_state']")));
										selectcity.selectByVisibleText("Florida");
										driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("13245");	
										Select selectcountry=new Select(driver.findElement(By.xpath("//*[@id='id_country']")));
										selectcountry.selectByVisibleText("United States");
										
										
										driver.findElement(By.id("phone_mobile")).sendKeys("1234567890");
										WebElement add=driver.findElement(By.xpath("//*[@id='alias']"));
										name.clear();
										name.sendKeys("usa");
										
										driver.findElement(By.id("submitAccount")).submit();
										
										System.out.println("Account created successfully");
										
	}
	
	@Test
	public void Title()
	{
		String actual=driver.getTitle();
		String expected="Login - My Store";
	boolean val=	actual.equalsIgnoreCase(expected);
		System.out.println(val);
										
				
	}
	
	
	
	
	
	
	
	
	
	
}
