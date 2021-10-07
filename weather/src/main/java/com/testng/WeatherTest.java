package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.utility.Selenium_Wrapper;
import com.weather.pages.HomePage;
import com.weather.pages.WeatherPage;

import io.github.bonigarcia.wdm.WebDriverManager;



public class WeatherTest {
	
	

	WebDriver driver;
	Selenium_Wrapper wrap;
	
	
	
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		wrap = new Selenium_Wrapper(driver);
		wrap.windowMaximize();
		wrap.deletecookies();
		wrap.launchUrl("https://www.ndtv.com");
		wrap.pageLoadTimeout(20, TimeUnit.SECONDS);
		wrap.implicitWait(20, TimeUnit.SECONDS);

	}
	
	@Test
	public void weatherTest() throws InterruptedException {
		
		HomePage homepage = new HomePage(driver);
		WeatherPage weatherpage = new WeatherPage(driver);
		
		Assert.assertEquals(wrap.getTheTitle(),"Get Latest News, India News, Breaking News, Today's News - NDTV.com");
		homepage.click_moreLink();
		homepage.click_weatherLink();
		wrap.pageLoadTimeout(20, TimeUnit.SECONDS);
		wrap.implicitWait(20, TimeUnit.SECONDS);
		
		weatherpage.typeCity("Ahmedabad");
		weatherpage.checkCity("Ahmedabad");
		Assert.assertTrue(weatherpage.verify_cityDisplayedOnMap("Ahmedabad"));
		weatherpage.celciusValueDisplayedForCity("Ahmedabad");
		weatherpage.fahrenheitValueDisplayedForCity("Ahmedabad");
		
		Assert.assertTrue(weatherpage.verify_cityDisplayedOnMap("Bhopal"));
		weatherpage.celciusValueDisplayedForCity("Bhopal");
		weatherpage.fahrenheitValueDisplayedForCity("Bhopal");
		
		weatherpage.clickCity("Kolkata");
		Assert.assertTrue(weatherpage.verify_temperaturePopup("Kolkata"));
		
		
		
		
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		wrap.closeBrowser();
	}
	

}
