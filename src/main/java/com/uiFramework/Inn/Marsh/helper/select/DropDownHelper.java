package com.uiFramework.Inn.Marsh.helper.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uiFramework.Inn.Marsh.helper.assertionHelper.VerificationHelper;
import com.uiFramework.Inn.Marsh.helper.logger.LoggerHelper;

public class DropDownHelper {
	private WebDriver driver;
	Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		log.info("DropDown object is created");
	}

	public void selectUsingValue(WebElement element, String value) {
		log.info("SelectUsingValue and value is " + value);
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void selectUsingVisibleText(WebElement element, String visibleText) {
		log.info("SelectUsingVisibleText and visibleText is " + visibleText);
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}

	public void selectUsingIndex(WebElement element, int index) {
		log.info("SelectUsingIndex and value is " + index);
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void deselectUsingValue(WebElement element, String value) {
		log.info("DeselectUsingValue and value is " + value);
		Select s = new Select(element);
		s.deselectByValue(value);
	}

	public void deselectUsingVisibleText(WebElement element, String visibleText) {
		log.info("DeselectUsingVisibleText and visibleText is " + visibleText);
		Select s = new Select(element);
		s.deselectByVisibleText(visibleText);
	}

	public void deselectUsingIndex(WebElement element, int index) {
		log.info("DeselectUsingIndex and value is " + index);
		Select s = new Select(element);
		s.deselectByIndex(index);
	}
	
	public List<String> getAllDropDownData(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allOptions = s.getOptions();
		List<String> valueList = new LinkedList<String>();
		for (WebElement option:allOptions) {
			log.info(option.getText());
			valueList.add(option.getText());
		}
		return valueList;
	}

}
