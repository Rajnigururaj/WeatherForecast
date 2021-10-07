package com.weather.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.utility.Selenium_Wrapper;

public class WeatherPage extends Selenium_Wrapper{

	WebDriver driver;
	



	String xpath_search_Text = "//input[@id='searchBox']";
	String xpath_city_CheckBox;
	String xpath_citiesDisplayed = "//div[@class='cityText']";
	String xpath_celcius;
	String xpath_fahrenheit;
	String xpath_temperaturePopup = "//div[@class='leaflet-pane leaflet-popup-pane']//span";


	String city;



	WebElement element;
	List<WebElement> elements;

	public WeatherPage(WebDriver driver) {
		super(driver);
		
		

	}

	public void typeCity(String city) {
		element = locateElement("xpath", xpath_search_Text);
		setText(element,city);
	}

	public void checkCity(String city) {
		xpath_city_CheckBox = "//input[@id='"+city+"']";
		click(xpath_city_CheckBox);
	}


	public boolean verify_cityDisplayedOnMap(String city) {
		elements = locateElements("xpath", xpath_citiesDisplayed);
		boolean cityDisplayed = false;
		for(int i=0;i<elements.size();i++) {
			if ((elements.get(i).getText().trim()).equals(city)) {
				cityDisplayed = true;
				break;
			}
		}
		return cityDisplayed;
	}

	
	public boolean celciusValueDisplayedForCity(String city) {
		xpath_celcius = "//div[@title='"+city+"']/div[@class='temperatureContainer']/span[@class='tempRedText']";
		elements = locateElements("xpath", xpath_citiesDisplayed);
		boolean celciusValueDisplayedForCity = false;
		for(int i=0;i<elements.size();i++) {
			if ((elements.get(i).getText().trim()).equals(city)) {
				element = locateElement("xpath",xpath_celcius);
				if(isDisplayed(element)) {
					celciusValueDisplayedForCity = true;
				}
				break;
			}
		}
		return celciusValueDisplayedForCity;
	}
	
	
	
	public boolean fahrenheitValueDisplayedForCity(String city) {
		xpath_fahrenheit = "//div[@title='"+city+"']/div[@class='temperatureContainer']/span[@class='tempWhiteText']";
		elements = locateElements("xpath", xpath_citiesDisplayed);
		boolean fahrenheitValueDisplayedForCity = false;
		for(int i=0;i<elements.size();i++) {
			if ((elements.get(i).getText().trim()).equals(city)) {
				element = locateElement("xpath",xpath_fahrenheit);
				if(isDisplayed(element)) {
					fahrenheitValueDisplayedForCity = true;
				}
				break;
			}
		}
		return fahrenheitValueDisplayedForCity;
	}
	
	public void clickCity(String city) {
		elements = locateElements("xpath", xpath_citiesDisplayed);
		for(int i=0;i<elements.size();i++) {

			if ((elements.get(i).getText().trim()).equals(city)) {
				elements.get(i).click();
				break;
			}
		}	
	}
	
	
	public boolean verify_temperaturePopup(String city) {
		boolean tempPopUpdetailsDisplayed = false; 

		elements = locateElements("xpath", xpath_temperaturePopup);

		for(int i=0;i<elements.size();i++) {

			if ((elements.get(i).getText().trim()).contains(city)) {

				tempPopUpdetailsDisplayed = true;

				break;
			}
		}
		return tempPopUpdetailsDisplayed;
	}

}


