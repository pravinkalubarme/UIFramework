package com.uiFramework.Inn.Marsh.helper.assertionHelper;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.uiFramework.Inn.Marsh.helper.logger.LoggerHelper;

public class AssertionHelper {
	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);

	public static void verifyText(String actual, String expected) {
		log.info("verifying text "+actual+" with"+ expected);
		Assert.assertEquals(actual, expected);
	}
	
	public static void makeTrue() {
		log.info("Making script PASS...");
		Assert.assertTrue(true);
	}
	
	public static void makeTrue(String message) {
		log.info("Making script PASS..."+message);
		Assert.assertTrue(true, message);
	}
	
	public static void makeFalse() {
		log.info("Making script FAIL...");
		Assert.assertTrue(false);
	}
	
	public static void makeFalse(String message) {
		log.info("Making script FAIL..."+message);
		Assert.assertTrue(false, message);
	}

	public static void verifyTrue(boolean status) {
		Assert.assertTrue(status);
	}
	public static void verifyFalse(boolean status) {
		Assert.assertTrue(status);
	}
	
	public static void verifyNull(String s) {
		log.info("Verify object is null");
		Assert.assertNull(s);
	}
	public static void verifyNotNull(String s) {
		log.info("Verify object is not null");
		Assert.assertNotNull(s);
	}
}
