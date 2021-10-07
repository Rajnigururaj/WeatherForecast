package com.weather.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.utility.Selenium_Wrapper;

public class HomePage extends Selenium_Wrapper {

	WebDriver driver;
	



	String xpath_more_link = "//a[@class='topnavmore']";
	String xpath_weather_Link = "//div[@class='topnav_cont']/a[text()='WEATHER']";

	String locator;
	String type;
	
	WebElement element;

	public HomePage(WebDriver driver) {
		super(driver);
		//this.driver = driver;

	}

	public void click_moreLink() {
		element = locateElement("xpath", xpath_more_link);
		click(element);
	}
	
	public WeatherPage click_weatherLink() {
		element = locateElement("xpath", xpath_weather_Link);
		click(element);
		return new WeatherPage(driver);
	}


}
