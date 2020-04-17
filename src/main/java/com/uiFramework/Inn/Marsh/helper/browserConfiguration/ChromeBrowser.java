package com.uiFramework.Inn.Marsh.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiFramework.Inn.Marsh.helper.resource.ResourceHelper;

public class ChromeBrowser {

	public ChromeOptions getChromeOptions() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		option.setCapability(ChromeOptions.CAPABILITY, chrome);
		
		if (System.getProperty("os.name").contains("Linex")) {
			option.addArguments("--headless","window-size=1024,768","--no-sanbox");
		}
		return option;
	}
	
	public WebDriver getChromeDriver(ChromeOptions cap) {
		
		if (System.getProperty("os.name").contains("Mac")) {
			System.getProperty("webdriver.chrome.driver",ResourceHelper.getResourcePath("/uiFramework/Drivers/chromedriver"));
			return new ChromeDriver(cap);
		}
		else if (System.getProperty("os.name").contains("Windows")) {
			System.getProperty("webdriver.chrome.driver",ResourceHelper.getResourcePath("/uiFramework/Drivers/chromedriver.exe"));
			return new ChromeDriver(cap);
		}
		else if (System.getProperty("os.name").contains("Linex")) {
			System.getProperty("webdriver.chrome.driver","/uiFramework/Drivers/chromedriver.exe");
			return new ChromeDriver(cap);
		}
		
		return null;
		
	}
}
