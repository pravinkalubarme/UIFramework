package com.uiFramework.Inn.Marsh.helper.resource;

public class ResourceHelper {
	public static String getResourcePath(String path) {
		String basePath=System.getProperty("user.dir");
		return basePath+path;
	}
	
	public static void main(String[] args) {
		System.out.println(ResourceHelper.getResourcePath("\\resources\\configFile\\log4j.properties"));
	}
}
