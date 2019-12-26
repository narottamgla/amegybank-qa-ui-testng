package com.amegybank.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(css = "ul.secondary-nav__misc-links li a")
	List<WebElement> topRightSideHomePageNaviagtionOptions;
	
	@FindBy(css = "ul.secondary-nav__user-segment li a")
	List<WebElement> topLeftSideHomePageNaviagtionOptions;
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<String> getTopRightSideHomePageNaviagtionOptions(){
		List<String> options = new ArrayList<String>();
		for(int i=0;i<topRightSideHomePageNaviagtionOptions.size();i++) {
			options.add(topRightSideHomePageNaviagtionOptions.get(i).getText());
		}
		return options;
	}
	
	public List<String> getTopLeftSideHomePageNaviagtionOptions(){
		List<String> options = new ArrayList<String>();
		for(WebElement option: topLeftSideHomePageNaviagtionOptions) {
			options.add(option.getText());
		}
		return options;
	}
}
