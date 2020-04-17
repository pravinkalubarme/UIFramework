package com.uiFramework.Inn.Marsh.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.uiFramework.Inn.Marsh.helper.assertionHelper.VerificationHelper;
import com.uiFramework.Inn.Marsh.helper.logger.LoggerHelper;

public class AlertHelper {

	private WebDriver driver;
	Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public AlertHelper(WebDriver driver) {
		this.driver = driver;
		log.info("Alert helper is created");
	}

	public Alert getAlert() {
		log.info("Alert text:" + driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		getAlert().accept();
		log.info("Alert is accepted");
	}

	public void dismissAlert() {
		getAlert().dismiss();
		log.info("Alert is dismissed");
	}

	public String getAlertText() {
		String text = getAlert().getText();
		log.info("Alert text: " + text);
		return text;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			log.info("Alert is present");
			return true;
		} catch (NoAlertPresentException e) {
			log.info(e.getCause());
			return false;
		}
	}

	public void acceptAlertIfPResent() {
		if (isAlertPresent()) {
			acceptAlert();
		} else {
			log.info("Alert is not present");
		}
	}

	public void dismissAlertIfPResent() {
		if (isAlertPresent()) {
			dismissAlert();
		} else {
			log.info("Alert is not present");
		}
	}

	public void acceptPromt(String text) {
		if (isAlertPresent()) {
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Alert text " + text);
		}
	}
}
