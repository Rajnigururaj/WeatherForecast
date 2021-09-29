package vanillaScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ndtv {

	@Test

	
	//abcd
	public static void vanillaScript() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.ndtv.com");

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();

		driver.findElement(By.xpath("//a[@class='topnavmore']")).click();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='topnav_cont']/a[text()='WEATHER']")).click();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		String city = "Ahmedabad";

		driver.findElement(By.id("searchBox")).sendKeys(city);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='"+city+"' and @type='checkbox']")).click();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		List<WebElement> citiesDisplayed = driver.findElements(By.xpath("//div[@class='cityText']"));

		boolean citiesDisplayedFlag = false;

		boolean tempInfoOfselecectedCity = false;

		for(int i=0;i<citiesDisplayed.size();i++) {

			if ((citiesDisplayed.get(i).getText().trim()).equals(city)) {

				citiesDisplayedFlag = true;


				if(driver.findElement(By.xpath("//div[@title='"+city+"']/div[@class='temperatureContainer']/span[@class='tempRedText']")).isDisplayed() && driver.findElement(By.xpath("//div[@title='"+city+"']/div[@class='temperatureContainer']/span[@class='tempWhiteText']")).isDisplayed()) {

					tempInfoOfselecectedCity = true;

				}
				break;
			}
		}

		if(citiesDisplayedFlag == true && tempInfoOfselecectedCity == true)

			System.out.println("SUCCESS!!!!!The following city is available on the map with temperature information "+city);

		else if(citiesDisplayedFlag == true && tempInfoOfselecectedCity == false)

			System.out.println("FAILURE!!!!!The following city is available on the map but the temperature information is not displayed "+city);

		else

			System.out.println("FAILURE!!!!!The following city is not available on the map "+city);

		String cityToBeClicked = "Patna";

		for(int i=0;i<citiesDisplayed.size();i++) {

			if ((citiesDisplayed.get(i).getText().trim()).equals(cityToBeClicked)) {
				citiesDisplayed.get(i).click();
				break;
			}
		}

		boolean tempPopUpdetailsDisplayed = false; 

		List<WebElement> temperaturePopUp = driver.findElements(By.xpath("//div[@class='leaflet-pane leaflet-popup-pane']//span"));

		for(int i=0;i<temperaturePopUp.size();i++) {

			if ((temperaturePopUp.get(i).getText().trim()).contains(cityToBeClicked)) {

				tempPopUpdetailsDisplayed = true;

				break;
			}
		}

		if (tempPopUpdetailsDisplayed == true)

			System.out.println("SUCCESS!!!!!Map displays the weather details of the city in the popup "+cityToBeClicked);
		else

			System.out.println("FAILURE!!!!Map does not display the weather details of the city in the popup "+cityToBeClicked);


		driver.quit();


	}

}
