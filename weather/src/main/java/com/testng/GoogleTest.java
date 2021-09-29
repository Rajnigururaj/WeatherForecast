package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}

	@Test(priority=2,groups="aaa")
	public void googleTitle() {

		String title = driver.getTitle();
		Assert.assertEquals(title, "Google1");
	}
	
	@Test(priority=1,groups="bbb",invocationCount = 3)
	public void googleLabel() {
		boolean lbl = driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
		Assert.assertTrue(lbl);
	}

	
	@Test(priority=3,groups="aaa",dependsOnMethods = "googleTitle")
	public void googleSearch() {
		boolean srch = driver.findElement(By.xpath("//input[@title='Search1']")).isDisplayed();
		Assert.assertTrue(srch);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
