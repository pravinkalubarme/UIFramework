package com.uiFramework.Inn.Marsh.helper.browserConfiguration.config;

import com.uiFramework.Inn.Marsh.helper.browserConfiguration.BrowserType;

public interface ConfigReader {
	
	public int getImplicitWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
}
