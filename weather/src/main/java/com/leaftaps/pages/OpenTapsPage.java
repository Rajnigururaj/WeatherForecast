package com.leaftaps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.utility.Selenium_Wrapper;

public class OpenTapsPage extends Selenium_Wrapper{

	WebDriver driver;




	String xpath_opentaps_img = "//*[contains(@src,'integratingweb')]";
	

	String locator;
	String type;

	WebElement element;

	public OpenTapsPage(WebDriver driver) {
		super(driver);

	}
	
	public HomePage click_openTapsLink() {
		element = locateElement("xpath", xpath_opentaps_img);
		click(element);
		return new HomePage(driver);
	}

}
