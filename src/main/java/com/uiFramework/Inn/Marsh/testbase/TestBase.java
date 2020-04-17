package com.uiFramework.Inn.Marsh.testbase;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.stat.inference.GTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiFramework.Inn.Marsh.helper.assertionHelper.VerificationHelper;
import com.uiFramework.Inn.Marsh.helper.browserConfiguration.BrowserType;
import com.uiFramework.Inn.Marsh.helper.browserConfiguration.ChromeBrowser;
import com.uiFramework.Inn.Marsh.helper.browserConfiguration.FirefoxBrowser;
import com.uiFramework.Inn.Marsh.helper.browserConfiguration.IExplorerBrowser;
import com.uiFramework.Inn.Marsh.helper.logger.LoggerHelper;
import com.uiFramework.Inn.Marsh.helper.wait.WaitHelper;
import com.uiFramework.Inn.Marsh.utils.ExtentManager;

public class TestBase {
	public static ExtentReports extent;
	public static ExtentTest test;
	private WebDriver driver;
	Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.getInstance();
	}

	@BeforeClass
	public void beforeClass() {
		test = extent.createTest(getClass().getName());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + " test started");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getTestClass() + " is passed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}

		extent.flush();
	}

	public WebDriver getBrowserObject(BrowserType btype) throws Exception {
		try {
			switch (btype) {
			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions option = chrome.getChromeOptions();
				return chrome.getChromeDriver(option);

			case Firefox:
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				FirefoxOptions options = firefox.getFirefoxOptions();
				return firefox.getFirefoxDriver(options);

			case Iexplorer:
				IExplorerBrowser iexplorer = IExplorerBrowser.class.newInstance();
				InternetExplorerOptions caps = iexplorer.getIExplorerCapabilities();
				return iexplorer.getInternetExplorerDriver(caps);
			default:
				throw new Exception("Driver not found " + btype.name());
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	public void setUpDriver(BrowserType btype) throws Exception {
		driver = getBrowserObject(btype);
		log.info("Initialize webdriver " + driver.hashCode());

		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(30, TimeUnit.SECONDS);
		wait.pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
}