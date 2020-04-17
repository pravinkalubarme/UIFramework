package com.uiFramework.Inn.Marsh.testScript;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.uiFramework.Inn.Marsh.helper.assertionHelper.AssertionHelper;
import com.uiFramework.Inn.Marsh.testbase.TestBase;

public class Test1 extends TestBase {

	@Test
	public void TC1() {
		AssertionHelper.makeTrue();
	}
	
	@Test
	public void TC2() {
		AssertionHelper.makeFalse();;
	}
	
	@Test
	public void TC3() {
		AssertionHelper.makeTrue();
	}
	
	@Test
	public void TC4() {
		AssertionHelper.makeFalse();;
	}
}