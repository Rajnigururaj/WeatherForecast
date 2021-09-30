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

import com.test.utility.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadTest {
	
	WebDriver driver;

	@BeforeClass
	@Parameters({"leaftapsurl","leaftapsusername","leaftapspassword"})
	
	public void setup(String leaftapsurl, String leaftapsusername, String leaftapspassword) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(leaftapsurl);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='username']")).clear();
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(leaftapsusername);
		driver.findElement(By.xpath("//*[@id='password']")).clear();
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(leaftapspassword);
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[contains(@src,'integratingweb')]")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	
	
	@Test(dataProvider="getTestData")
	public void test(String cName, String fName, String lName, String address, String city, String zip, String state) {
		
		
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys(cName);
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys(fName);
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys(lName);
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalAddress1']")).clear();
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalAddress1']")).sendKeys(address);
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalCity']")).clear();
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalCity']")).sendKeys(city);
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalPostalCode']")).clear();
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalPostalCode']")).sendKeys(zip);
		
		Select stdrpDown = new Select(driver.findElement(By.xpath("//select[@id='createLeadForm_generalStateProvinceGeoId']")));
		stdrpDown.selectByVisibleText(state);
		
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		Boolean successPage = driver.getTitle().toString().contains("View Lead");
		
		Assert.assertTrue(successPage);
	}
	
	@AfterMethod
	public void backToHome() {
		driver.findElement(By.xpath("//a[text()='My Home']")).click();
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	
	
	
	
}
