package com.leaftaps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.utility.Selenium_Wrapper;

public class HomePage extends Selenium_Wrapper{
	
	WebDriver driver;
	
	String xpath_CreateLead_Button = "//a[text()='Create Lead']";
	
	String locator;
	String type;

	WebElement element;

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public CreateLeadPage click_CreateLeadButton() {
		element = locateElement("xpath", xpath_CreateLead_Button);
		click(element);
		return new CreateLeadPage(driver);
	}

}
