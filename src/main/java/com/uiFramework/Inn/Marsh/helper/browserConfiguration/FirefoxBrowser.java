package com.uiFramework.Inn.Marsh.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiFramework.Inn.Marsh.helper.resource.ResourceHelper;

public class FirefoxBrowser {
	
	public FirefoxOptions getFirefoxOptions() {
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
	
		DesiredCapabilities firefox = DesiredCapabilities.firefox();
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("mariontte", true);

		FirefoxOptions option = new FirefoxOptions(firefox);
		
		if (System.getProperty("os.name").contains("Linex")) {
			option.addArguments("--headless","window-size=1024,768","--no-sanbox");
		}
		return option;
	}
	
	public WebDriver getFirefoxDriver(FirefoxOptions cap) {
		if (System.getProperty("os.name").contains("Mac")) {
			System.getProperty("webdriver.chrome.driver",ResourceHelper.getResourcePath("/uiFramework/Drivers/geckodriver"));
			return new FirefoxDriver(cap);
		}
		else if (System.getProperty("os.name").contains("Windows")) {
			System.getProperty("webdriver.chrome.driver",ResourceHelper.getResourcePath("/uiFramework/Drivers/geckodriver.exe"));
			return new FirefoxDriver(cap);
		}
		else if (System.getProperty("os.name").contains("Linex")) {
			System.getProperty("webdriver.chrome.driver","/uiFramework/Drivers/geckodriver.exe");
			return new FirefoxDriver(cap);
		}
		return null;
	}

}
