package com.leaftaps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.utility.Selenium_Wrapper;


public class LoginPage extends Selenium_Wrapper {

	WebDriver driver;
	



	String xpath_username_Text = "//*[@id='username']";
	String xpath_password_Text = "//*[@id='password']";
	String xpath_login_Button = "//*[@value='Login']";

	String locator;
	String type;
	
	WebElement element;

	public LoginPage(WebDriver driver) {
		super(driver);
		//this.driver = driver;

	}

	public void setText_username(String username) {
		element = locateElement("xpath", xpath_username_Text);
		setText(element, username);
	}
	
	
	
	public void setText_password(String password) {
		element = locateElement("xpath", xpath_password_Text);
		setText(element, password);
	}
	
	public OpenTapsPage click_Login() {
		element = locateElement("xpath", xpath_login_Button);
		click(element);
		return new OpenTapsPage(driver);
	}


}