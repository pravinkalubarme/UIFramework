package com.uiFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.uiFramework.Inn.Marsh.helper.browserConfiguration.ChromeBrowser;

public class Demo {
	public static void main(String[] args) {
		String s = "gh1hv1hvn3";
		int sum=0;
		for (int i = 0; i < s.length(); i++) 
		{
			char chara = s.charAt(i);
			if (Character.isDigit(chara)) {
			   int no = Integer.parseInt(Character.toString(chara));
			   sum=sum+no;
			}
		}
		System.out.println(sum);
	
	
		WebDriver driver= new ChromeDriver();
		driver.get("");
		List<WebElement> elems = driver.findElements(By.xpath(""));
		for (int i = 0; i < elems.size(); i++) {
			elems.get(i).getText();
			System.out.println(elems.get(i).getText());
		}
		
	}
	

	
	
}