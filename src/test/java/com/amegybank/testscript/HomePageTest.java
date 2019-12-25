package com.amegybank.testscript;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest {
	WebDriver driver;

	@Test(priority = 1)
	public void verifyHomePageNavigation() {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amegybank.com/");
		Assert.assertEquals(driver.getTitle(), "Personal Accounts | Amegy Bank of Texas");

	}

	@Test(priority = 2)
	public void verifyTopMenusOnHomePage() {
		List<WebElement> homePageTopMenuOptionsLeftSide = driver.findElements(By.cssSelector("ul.secondary-nav__user-segment li a"));
		List<String> leftSideOptioins = new ArrayList<String>();
		for(int i=0;i<homePageTopMenuOptionsLeftSide.size();i++) {
			leftSideOptioins.add(homePageTopMenuOptionsLeftSide.get(i).getText());
		}
		
		String[] sourceArray = {"PERSONAL","BUSINESS","WEALTH" };

		Assert.assertEquals(leftSideOptioins, Arrays.asList(sourceArray));
		driver.close();
		driver.quit();

	}
}
