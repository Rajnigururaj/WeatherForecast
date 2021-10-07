package com.testng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.leaftaps.pages.CreateLeadPage;
import com.leaftaps.pages.HomePage;
import com.leaftaps.pages.LoginPage;
import com.leaftaps.pages.OpenTapsPage;
import com.leaftaps.pages.ViewLeadsPage;
import com.test.utility.Selenium_Wrapper;
import com.test.utility.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadFinalTest {
	
	WebDriver driver;
	Selenium_Wrapper wrap;
	
	@BeforeMethod
	@Parameters({"leaftapsurl","leaftapsusername","leaftapspassword"})
	public void setup(String leaftapsurl, String leaftapsusername, String leaftapspassword) {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		wrap = new Selenium_Wrapper(driver);
		
		LoginPage loginpage = new LoginPage(driver);
		OpenTapsPage opentapspage = new OpenTapsPage(driver);
		
		
		
		
		wrap.windowMaximize();
		wrap.deletecookies();
		wrap.launchUrl(leaftapsurl);
		wrap.pageLoadTimeout(20, TimeUnit.SECONDS);
		wrap.implicitWait(20, TimeUnit.SECONDS);

		loginpage.setText_username(leaftapsusername);
		loginpage.setText_password(leaftapspassword);
		loginpage.click_Login();
		wrap.pageLoadTimeout(20, TimeUnit.SECONDS);
		wrap.implicitWait(20, TimeUnit.SECONDS);

		opentapspage.click_openTapsLink();
		wrap.pageLoadTimeout(20, TimeUnit.SECONDS);
		wrap.implicitWait(20, TimeUnit.SECONDS);
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider="getTestData")
	public void createLead(String cName, String fName, String lName, String address, String city, String zip, String state) {
		
		HomePage homepage = new HomePage(driver);
		CreateLeadPage createleadpage = new CreateLeadPage(driver);
		
		
		homepage.click_CreateLeadButton();
		
		wrap.pageLoadTimeout(20, TimeUnit.SECONDS);
		wrap.implicitWait(20, TimeUnit.SECONDS);


		createleadpage.setText_companyName(cName);
		createleadpage.setText_firstName(fName);
		createleadpage.setText_lastName(lName);
		createleadpage.setText_address(address);
		createleadpage.setText_city(city);
		createleadpage.setText_zip(zip);
		createleadpage.selectState(state);

		createleadpage.click_CreateLead();
		

		wrap.pageLoadTimeout(20, TimeUnit.SECONDS);
		wrap.implicitWait(20, TimeUnit.SECONDS);




		Boolean successPage = wrap.getTheTitle().contains("View Lead");

		Assert.assertTrue(successPage);
		
	}
	
	@AfterMethod
	public void tearDown() {
		wrap.closeBrowser();
	}

}
