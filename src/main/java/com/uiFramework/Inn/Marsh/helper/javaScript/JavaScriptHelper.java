package com.uiFramework.Inn.Marsh.helper.javaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.Inn.Marsh.helper.logger.LoggerHelper;

public class JavaScriptHelper {
	
	private WebDriver driver;
	private Logger log= LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver) {
		this.driver=driver;
		log.info("Java script helper has been initialized");
	}

	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	public Object executeScript(String script, Object...arg) {
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script, arg);
	}
	
	public void scrollToElement(WebElement element) {
		log.info("Scroll to WebElement...");
		executeScript("window.scrollTo(arguments[0], arguments[1])", element.getLocation().x,element.getLocation().y);
	}
	
	public void scrollToElementAndClick(WebElement element) {
		log.info("Scroll to WebElement...");
	    scrollToElement(element);
	    element.click();
	    log.info("Element is clicked "+element.toString());
	}
	
	public void scrollDownVertically() {
		log.info("Scrolling down vertically");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	public void scrollUpVertically() {
		log.info("Scrolling up vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		
	}
	
	/*
	 * This method will scroll till given pixel
	 */
	public void scrollDownByPixel(int pixel) {

		executeScript("window.scollBY(0,"+pixel+")");
	}	
	
	public void scrollUpByPixel(int pixel) {

		executeScript("window.scollBY(0,-"+pixel+")");
	}
	
	/*
	 * This method will zoom screen by 100%
	 */
	public void zoomBy100Percentage() {

		executeScript("document.body.style.zoom='100%'");
	}
	
	/*
	 * This method will zoom screen by 60%
	 */
	public void zoomBy60Percentage() {

		executeScript("document.body.style.zoom='60%'");
	}
	
	public void clickElement(WebElement element) {
		executeScript("argument[0],click()", element);
	}
}
