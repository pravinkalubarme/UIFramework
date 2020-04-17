package com.uiFramework.Inn.Marsh.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiFramework.Inn.Marsh.helper.resource.ResourceHelper;

public class IExplorerBrowser {
	public InternetExplorerOptions getIExplorerCapabilities() {		
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setJavascriptEnabled(true);

		InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions(cap);
		return internetExplorerOptions;
	}
	
	public WebDriver getInternetExplorerDriver(InternetExplorerOptions cap) { 
			System.setProperty("webdriver.ie.driver",ResourceHelper.getResourcePath("/uiFramework/Drivers/iedriver.exe"));
			return new InternetExplorerDriver(cap);
	}
}
