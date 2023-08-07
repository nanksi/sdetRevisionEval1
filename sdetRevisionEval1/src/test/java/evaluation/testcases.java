package evaluation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testcases {
	WebDriver driver;

	@BeforeTest
	public void openbrowser() {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url= "https://www.goodreads.com/";
		driver.get(url);
	}
	
	@Test(priority = 0)
	public void loginToGoodreads() {
		driver.findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Sign in with email')]")).click();
		driver.findElement(By.id("ap_email")).sendKeys("nandan3512@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("qwerty");
		driver.findElement(By.id("signInSubmit")).click();
	}
	
	@Test(priority = 1)
	public void searchBookTitle() {
		driver.findElement(By.xpath("(//button[@class='gr-iconButton'])[1]")).click();
		driver.findElement(By.xpath("//*[@class='searchBox__input searchBox__input--currentlyReading']")).sendKeys("My Name Is Iris");
		driver.findElement(By.xpath("//*[@class='searchBox__input searchBox__input--currentlyReading']")).sendKeys(Keys.ENTER);
	}
	
	@Test(priority = 2)
	public void markWantToRead() throws InterruptedException {
		driver.findElement(By.xpath("(//*[contains(text(),'Want to Read')])[1]")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 3)
	public void removeSelectedBook() {
		driver.findElement(By.xpath("//*[contains(text(),'My Books')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'My Name Is Iris')]")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Want to read')])[1]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Remove from my shelf')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Remove')]")).click();
	}
	
	@Test(priority = 4)
	public void logout() {
		driver.findElement(By.className("UserIcon")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Sign out')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'click here.')]")).click();
	}
	
}
