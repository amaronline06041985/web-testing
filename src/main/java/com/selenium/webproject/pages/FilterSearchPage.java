package com.selenium.webproject.pages;

import org.testng.Assert;

import com.selenium.webproject.base.BasePage;
import com.selenium.webproject.pages.*;

public class FilterSearchPage extends BasePage {
	public FilterSearchPage() throws InterruptedException {
		super();
	}

	public void searchFilter( String searchTypeLocator,String searchTypeValue, String textlocatorKey,String searchText) throws InterruptedException {
		driver.get(config.getProperty("Url"));
		click("Users");
		input(searchTypeLocator,searchTypeValue);
		input(textlocatorKey,searchText);
		click("Filter_button");
		
	}
	public void verifyValidSearch(String expectedCurrentFilterText) {
		String actualText_xpath = objectRepository.getProperty("currentFilterSearchValue");
		String searchResult=objectRepository.getProperty("searchRecordKey");
		String searchResultText=readText(searchResult);
		Assert.assertEquals(readText(actualText_xpath), expectedCurrentFilterText);
		Assert.assertEquals(searchResultText, "View");
		
	}
	public void verifyInvalidSearch(String expectedCurrentFilterText) {
		String actualText_xpath = objectRepository.getProperty("currentFilterSearchValue");
		String searchNoResult=objectRepository.getProperty("searchNoRecordKey");
		String searchNoResultText=readText(searchNoResult);
		Assert.assertEquals(readText(actualText_xpath), expectedCurrentFilterText);
		Assert.assertEquals(searchNoResultText, "No Users found");
	}
	
}
