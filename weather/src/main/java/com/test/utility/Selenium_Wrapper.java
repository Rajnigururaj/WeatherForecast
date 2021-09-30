package com.test.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Wrapper {
	
	private WebDriver driver;
	
	public Selenium_Wrapper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void launchUrl(String url) {
		driver.get(url);
	}
	
	
	public void setText(String locator, String text) {
		driver.findElement(By.xpath(locator)).clear();
		driver.findElement(By.xpath(locator)).sendKeys(text);
	}
	
	public void click(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}
	
	public void selectDropDownByVisibleText(String locator, String text) {
		Select drp = new Select(driver.findElement(By.xpath(locator)));
		drp.selectByVisibleText(text);
	}
	
	public String getTheTitle() {
		return driver.getTitle();
	}
	
	public void pageLoadTimeout(long time, TimeUnit unit) {
		driver.manage().timeouts().pageLoadTimeout(time, unit);
	}
	
	public void implicitWait(long time, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(time, unit);
	}

	public void windowMaximize() {
		driver.manage().window().maximize();
	}
	
	public void deletecookies() {
		driver.manage().deleteAllCookies();
	}
}
