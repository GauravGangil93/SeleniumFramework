package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LogInPage;

public class LoginApplication extends BaseClass{
	
	// reference declaration
	LogInPage login;
	DashboardPage dashboard;
	
	@Test(priority = 1)	
	public void loginWithValidCredentials() 
	{	
		login = new LogInPage(driver);
		dashboard= login.loginToApplication("admin@email.com", "admin@123");
		Assert.assertTrue(dashboard.getWelcomeText().contains("Welcome"),"Login Failed");
	}
	
	@Test(dependsOnMethods = "loginWithValidCredentials",priority = 2)
	public void logoutFromApplication() 
	{
		dashboard.logoutFromApplication();
		Assert.assertTrue(login.isSignUpPresent(),"LogOut Failed");

	}
	
	@Test(priority = 3)
	public void verifyFooterLinks() 
	{
		int count= login.countFooterLinks();
		assertEquals(4,count,"footer links mismatched");
	}
}


