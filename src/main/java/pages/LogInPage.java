package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
	WebDriver driver;
	
	public LogInPage(WebDriver driver) 
	{
		this.driver=driver;
		
	}
	
	By username=By.id("email1");
	By password=By.id("password1");
	By loginButton= By.className("submit-btn");
	By signIn= By.xpath("//h2[normalize-space()='Sign In']");
	By footerIcon= By.xpath("//div[contains(@class,'footer')]//a");
	
	public boolean isSignUpPresent() {
		boolean status= driver.findElement(signIn).isDisplayed();
		return status;	
	}

	
	public DashboardPage loginToApplication(String user, String pass) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
		 
		// Page chaining
		DashboardPage dashboard= new DashboardPage(driver);
		return dashboard;
	}
	
	
	public int countFooterLinks() 
	{
		int count= driver.findElements(footerIcon).size();
		return count;
	}
	
	
}
