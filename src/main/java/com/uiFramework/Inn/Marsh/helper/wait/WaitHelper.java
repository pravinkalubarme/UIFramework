package com.uiFramework.Inn.Marsh.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiFramework.Inn.Marsh.helper.logger.LoggerHelper;

public class WaitHelper {

	private WebDriver driver;
	
	Logger log=LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
    public void setImplicitWait(long timeout, TimeUnit unit) {
    	log.info("Implicit wait has been set: "+timeout+" "+unit);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}

    
    private WebDriverWait getWait(int TimeoutInSec,int PollingEveryMilliSec) {
    	WebDriverWait wait = new WebDriverWait(driver, TimeoutInSec);
    	wait.pollingEvery(Duration.ofMillis(PollingEveryMilliSec));
    	wait.ignoring(NoSuchElementException.class);
    	wait.ignoring(ElementNotVisibleException.class);
    	wait.ignoring(StaleElementReferenceException.class);
    	wait.ignoring(NoSuchFrameException.class);
    	return wait;
    	
    }
    
    public void WaitElementToBeVisible(WebElement element, int TimeoutInSec) {
    	log.info("Waiting for "+element.toString()+" for: "+TimeoutInSec+" seconds");
    	WebDriverWait wait = new WebDriverWait(driver, TimeoutInSec);
    	wait.until(ExpectedConditions.visibilityOf(element));
    	log.info("Element is clickable now");
    }
    
    
    
    public void WaitElementclickable(WebElement element, int TimeoutInSec) {
    	log.info("Waiting for "+element.toString()+" for: "+TimeoutInSec+" seconds");
    	WebDriverWait wait = new WebDriverWait(driver, TimeoutInSec);
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    	log.info("Element is clickable now");
    }
    
    public void WaitElementNotPresent(WebElement element, int TimeoutInSec) {
    	log.info("Waiting for "+element.toString()+" for: "+TimeoutInSec+" seconds");
    	WebDriverWait wait = new WebDriverWait(driver, TimeoutInSec);
    	wait.until(ExpectedConditions.invisibilityOf(element));
    	log.info("Element is Not Present now");
    }
    
    public void WaitForFrameToBeAvailableAndSwitchToIt(WebElement element, int TimeoutInSec) {
    	log.info("Waiting for "+element.toString()+" for: "+TimeoutInSec+" seconds");
    	WebDriverWait wait = new WebDriverWait(driver, TimeoutInSec);
    	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    	log.info("Frame is Available And Switch To It now");
    }
    
    public FluentWait<WebDriver> getFluentWait()
    {
    	FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
    			.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
    			
    	return fWait;
    }
    
    public void pageLoadTimeout(long timeout, TimeUnit unit)
    {
    	log.info("Waiting for page to load for "+timeout+ "seconds");
    	driver.manage().timeouts().pageLoadTimeout(timeout, unit);
    }
}
