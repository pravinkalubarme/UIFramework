package com.uiFramework.Inn.Marsh.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(xpath="//input[@type='email']") WebElement userName;
	
	@FindBy(id="pass") WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']") WebElement login;
	
	//@FindBy(xpath="") WebElement usernameMessage;
	
	//@FindBy(xpath="") WebElement passwordMessage;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginPageUserName(String username) {
		userName.sendKeys(username);
	}
	
	public void loginPagePassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void loginPageLoginButton() {
		login.click();
	}
}
