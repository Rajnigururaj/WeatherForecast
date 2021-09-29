package com.test.utility;

import java.util.ArrayList;

import com.excel.lib.util.Xls_Reader;

public class TestUtil {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("/Users/rajnigururajaacharya/Documents/GitHub/WeatherForecast/weather/src/main/java/com/excel/xls/Lead_Input.xlsx");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 2; i<=reader.getRowCount("Sheet1"); i++) {
			String companyName = reader.getCellData("Sheet1", "CompanyName",i);
			String firstName = reader.getCellData("Sheet1", "FirstName",i);
			String lastName = reader.getCellData("Sheet1", "LastName",i);
			String address = reader.getCellData("Sheet1", "Address",i);
			String city = reader.getCellData("Sheet1", "City",i);
			String zipCode = reader.getCellData("Sheet1", "ZipCode",i);
			String state = reader.getCellData("Sheet1", "State",i);
			
			Object[] ob = {companyName, firstName, lastName, address, city, zipCode, state};
			myData.add(ob);
		}

		return myData;	
	}
	
}
