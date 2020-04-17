package com.uiFramework.Inn.Marsh.helper.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.uiFramework.Inn.Marsh.helper.logger.LoggerHelper;


public class Retry implements IRetryAnalyzer{

	Logger log= LoggerHelper.getLogger(Retry.class);
	private int retryCount=0;
	private int maxRetryCount=3;
	
	public boolean retry(ITestResult arg0) {
		if (retryCount<maxRetryCount) {
			log.info("Retrying test "+arg0.getName()+" with status "+getResultStatusName(arg0.getStatus())+" for the "+(retryCount+1)+"times. ");
			retryCount++;
		}
		return true;
	}
	
	public String getResultStatusName(int status) {	
		String resultName=null;
		if (status==1) {
			resultName="SUCCESS";	
		}
		if (status==2) {
			resultName="FAILURE";	
		}
		if (status==3) {
			resultName="SKIP";	
		}
		return resultName;
	}
}
