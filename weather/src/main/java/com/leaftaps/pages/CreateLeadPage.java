package com.leaftaps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.utility.Selenium_Wrapper;

public class CreateLeadPage extends Selenium_Wrapper{

	WebDriver driver;

	String xpath_CompanyName_Text = "//input[@id='createLeadForm_companyName']";
	String xpath_FirstName_Text = "//input[@id='createLeadForm_firstName']";
	String xpath_LastName_Text = "//input[@id='createLeadForm_lastName']";
	String xpath_Address_Text = "//input[@id='createLeadForm_generalAddress1']";
	String xpath_City_Text = "//input[@id='createLeadForm_generalCity']";
	String xpath_zip_Text = "//input[@id='createLeadForm_generalPostalCode']";
	String xpath_State_DDValue = "//select[@id='createLeadForm_generalStateProvinceGeoId']";
	String xpath_CreateLeadButton = "//input[@value='Create Lead']";
									

	String locator;
	String type;

	WebElement element;

	public CreateLeadPage(WebDriver driver) {
		super(driver);

	}
	
	public void setText_companyName(String cName) {
		element = locateElement("xpath", xpath_CompanyName_Text);
		setText(element, cName);
	}
	public void setText_firstName(String fName) {
		element = locateElement("xpath", xpath_FirstName_Text);
		setText(element, fName);
	}
	public void setText_lastName(String lName) {
		element = locateElement("xpath", xpath_LastName_Text);
		setText(element, lName);
	}
	public void setText_city(String city) {
		element = locateElement("xpath", xpath_City_Text);
		setText(element, city);
	}
	public void setText_zip(String zip) {
		element = locateElement("xpath", xpath_zip_Text);
		setText(element, zip);
	}
	public void setText_address(String address) {
		element = locateElement("xpath", xpath_Address_Text);
		setText(element, address);
	}
	
	public void selectState(String state) {
		selectDropDownByVisibleText(xpath_State_DDValue, state);
	}
	
	
	
	public ViewLeadsPage click_CreateLead() {
		element = locateElement("xpath", xpath_CreateLeadButton);
		click(element);
		return new ViewLeadsPage(driver);
	}

}
