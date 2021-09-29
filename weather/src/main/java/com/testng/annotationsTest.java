package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class annotationsTest {

	@BeforeSuite
	public void beforeSuiteMthd() {
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTestMthd() {
		System.out.println("Before Test");
	}
	
	
	@BeforeClass
	public void beforeClassMthd() {
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforeMethodMthd() {
		System.out.println("Before Method");
	}
	
	@Test
	public void testOneMthd() {
		System.out.println("Test one");
	}
	
	@Test
	public void testTwoMthd() {
		System.out.println("Test two");
	}
	
	@Test
	public void testThreeMthd() {
		System.out.println("Test three");
	}
	
	@AfterMethod
	public void afterMethodMthd() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClassMthd() {
		System.out.println("After class");
	}
	
	@AfterTest
	public void afterTestMthd() {
		System.out.println("After Test");
	}
	
	@AfterSuite
	public void afterSuiteMthd() {
		System.out.println("After Suite");
	}
	
}
