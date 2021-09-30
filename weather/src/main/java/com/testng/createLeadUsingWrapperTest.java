package com.testng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.utility.Selenium_Wrapper;
import com.test.utility.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createLeadUsingWrapperTest {
	
	WebDriver driver;
	Selenium_Wrapper wrap;


	@BeforeClass
	@Parameters({"leaftapsurl","leaftapsusername","leaftapspassword"})
	
	public void setup(String leaftapsurl, String leaftapsusername, String leaftapspassword) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wrap = new Selenium_Wrapper(driver);
		
		
		wrap.windowMaximize();
		wrap.deletecookies();
		wrap.launchUrl(leaftapsurl);
		wrap.pageLoadTimeout(20, TimeUnit.SECONDS);
		wrap.implicitWait(20, TimeUnit.SECONDS);
		
		wrap.setText("//*[@id='username']", leaftapsusername);
		wrap.setText("//*[@id='password']", leaftapspassword);
		wrap.click("//*[@value='Login']");
		wrap.pageLoadTimeout(20, TimeUnit.SECONDS);
		wrap.implicitWait(20, TimeUnit.SECONDS);
		
		wrap.click("//*[contains(@src,'integratingweb')]");
		wrap.pageLoadTimeout(20, TimeUnit.SECONDS);
		wrap.implicitWait(20, TimeUnit.SECONDS);
		
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	
	
	@Test(dataProvider="getTestData")
	public void test(String cName, String fName, String lName, String address, String city, String zip, String state) {
		
		
		wrap.click("//a[text()='Create Lead']");
		wrap.pageLoadTimeout(20, TimeUnit.SECONDS);
		wrap.implicitWait(20, TimeUnit.SECONDS);
		
		
		wrap.setText("//input[@id='createLeadForm_companyName']", cName);
		wrap.setText("//input[@id='createLeadForm_firstName']", fName);
		wrap.setText("//input[@id='createLeadForm_lastName']", lName);
		wrap.setText("//input[@id='createLeadForm_generalAddress1']", address);
		wrap.setText("//input[@id='createLeadForm_generalCity']", city);
		wrap.setText("//input[@id='createLeadForm_generalPostalCode']", zip);
		
		wrap.selectDropDownByVisibleText("//select[@id='createLeadForm_generalStateProvinceGeoId']", state);
		wrap.click("//input[@value='Create Lead']");
		
		wrap.pageLoadTimeout(20, TimeUnit.SECONDS);
		wrap.implicitWait(20, TimeUnit.SECONDS);
		
	
		
		
		Boolean successPage = wrap.getTheTitle().contains("View Lead");
		
		Assert.assertTrue(successPage);
	}
	
	@AfterMethod
	public void backToHome() {
		wrap.click("//a[text()='My Home']");
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	
	
	
	
}
