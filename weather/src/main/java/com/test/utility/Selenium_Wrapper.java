package com.test.utility;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;


public class Selenium_Wrapper {

	WebDriver driver;
	


	public Selenium_Wrapper(WebDriver driver) {
		this.driver = driver;
	}


	public void launchUrl(String url) {
		driver.get(url);
	}

	public WebElement locateElement(String type, String locator) {
		WebElement element;
		switch(type.toLowerCase()) {
		case "xpath":
			//System.out.println(locator);
			element = driver.findElement(By.xpath(locator));
			break;
		case "id":
			element = driver.findElement(By.id(locator));
			break;
		case "name":
			element = driver.findElement(By.name(locator));
			break;
		default:
			element = driver.findElement(By.xpath(locator));
			break;

		}
		return element;
	}
	
	
	public List<WebElement> locateElements(String type, String locator){
		List<WebElement> elements;
		switch(type.toLowerCase()) {
		case "xpath":
			elements = driver.findElements(By.xpath(locator));
			break;
		case "id":
			elements = driver.findElements(By.id(locator));
			break;
		case "name":
			elements = driver.findElements(By.name(locator));
			break;
		default:
			elements = driver.findElements(By.xpath(locator));
			break;

		}
		return elements;
	}


	public void setText(String locator, String text) {
		driver.findElement(By.xpath(locator)).clear();
		driver.findElement(By.xpath(locator)).sendKeys(text);
	}
	
	public void setText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void click(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}
	
	public void click(WebElement element) {
		element.click();
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

	public void closeBrowser() {
		driver.quit();
	}
	
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
}
