package com.amegybank.testscript;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amegybank.page.HomePage;

public class HomePagePOMTest extends BaseTest {

	@Test(priority = 1)
	public void verifyHomePageNavigation() {
		driver.get("https://www.amegybank.com/");
		Assert.assertEquals(driver.getTitle(), "Personal Accounts | Amegy Bank of Texas");

	}

	@Test(priority = 2)
	public void verifyTopMenusOnHomePage() {
		HomePage homePage = new HomePage(driver);
		String[] sourceArray = { "PERSONAL", "BUSINESS", "WEALTH" };
		Assert.assertEquals(homePage.getTopLeftSideHomePageNaviagtionOptions(), Arrays.asList(sourceArray));

	}

}
