package com.uiFramework.Inn.Marsh.helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.uiFramework.Inn.Marsh.helper.logger.LoggerHelper;

public class WindowHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WindowHelper.class);

	public WindowHelper(WebDriver driver) {
		this.driver = driver;
	}

	
	/*
	 * This method will switch to parent window
	 */
	public void switchToParentWindow() {
		driver.switchTo().defaultContent();
		log.info("switch to parent window");
	}

	/*
	 * This method will switch to child window based on index
	 */
	public void switchToWindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) {
			if (i == index) {
				log.info("switch to "+index+" window");
				driver.switchTo().window(window);
			} else {
				i++;
			}
		}
	}
	
	/*
	 * This method will close all child window and 
	 * switch to main window
	 */
	public void closeAllTabsAndSwitchToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainWindow = driver.getWindowHandle();
		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainWindow)) {
				driver.close();
			} 
		}
		log.info("switch to main window");
		driver.switchTo().window(mainWindow);
	}
	
	public void navigateBack()
	{
		log.info("Navigating back");
		driver.navigate().back();
	}
	
	public void navigateForword()
	{
		log.info("Navigating forward");
		driver.navigate().back();
	}
	
}
