package com.uiFramework.Inn.Marsh.helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.Inn.Marsh.helper.logger.LoggerHelper;

public class SwitchHelper {
	
	private WebDriver driver;
	private Logger log= LoggerHelper.getLogger(SwitchHelper.class);
	
	public SwitchHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	/*
	 * This method will switch to frame based on frameIndex
	 * @param frameIndex
	 */
	public void switchToFrame(int frameIndex) {
		driver.switchTo().frame(frameIndex);
		log.info("Switched to "+frameIndex+" frame");
	}
	
	/*
	 * This method will switch to frame based on frameName
	 * @param frameName
	 */
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
		log.info("Switched to "+frameName+" frame");
	}
	
	/*
	 * This method will switch to frame based on Element
	 * @param web element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
		log.info("Switched to "+element.toString());
	}
}
