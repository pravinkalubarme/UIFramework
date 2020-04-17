package com.uiFramework.Inn.Marsh.helper.assertionHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.Inn.Marsh.helper.logger.LoggerHelper;

public class VerificationHelper {

	private WebDriver driver;
	Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public VerificationHelper(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("Element is displayed..." + element.getText());
			return true;
		} catch (Exception e) {
			log.error("Element is not displayed...", e.getCause());
			return false;
		}
	}

	public boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("Element is displayed..." + element.getText());
			return false;
		} catch (Exception e) {
			log.error("Element is not displayed...");
			return true;
		}
	}

	public String readValueFromTElement(WebElement element) {
		if (null == element) {
			log.info("Webelement is null");
			return null;
		}

		boolean status = isDisplayed(element);
		if (status) {
			log.info("element text is "+element.getText());
			return element.getText();
		} 
		else {
			return null;
		}
	}
}
