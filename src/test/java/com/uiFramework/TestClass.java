package com.uiFramework;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiFramework.Inn.Marsh.pageObject.LoginPage;

public class TestClass {
	
	@Test (description=" Select Month")
	public void TC1() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pravi\\eclipse-workspace\\uiFramework\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
//	    LoginPage loginPage = new LoginPage(driver);
//	    loginPage.loginPageUserName("pravinkalubarme1150@gmail.com");
//	    Thread.sleep(2000);
//	    loginPage.loginPagePassword("Prageeta@27");
//	    Thread.sleep(2000);
//	    loginPage.loginPageLoginButton();
//	    Thread.sleep(2000);
//        String pageTitle=driver.getTitle();
//        pageTitle.contains("Facebook");
//        assertTrue(pageTitle.contains("Facebook"));
        
		WebElement month = driver.findElement(By.id("month"));
        month.click();
        Actions a= new Actions(driver);
        for (int i = 1; i <=7; i++) {
        	a.sendKeys(Keys.ARROW_DOWN).perform();
        	Thread.sleep(1000);
		}
        a.sendKeys(Keys.ENTER).perform();
	}
}
