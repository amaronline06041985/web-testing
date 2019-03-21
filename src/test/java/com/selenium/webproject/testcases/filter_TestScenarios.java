package com.selenium.webproject.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.selenium.webproject.base.BasePage;
import com.selenium.webproject.pages.FilterSearchPage;

public class filter_TestScenarios extends BasePage{

	public filter_TestScenarios() throws InterruptedException {
		super();
	}
	FilterSearchPage filterSearchObject = new FilterSearchPage();
	
	@AfterTest(description="Closing the browser")
	public void closeBrowser(){
	driver.quit(); 
	} 
	@Test ( description="Username Valid Search criteria-Contains ")
    public void validUserNameSearch_correctUsername () throws Exception  {
        //invoke newUserCreation function of New User class
		String CurrentFilterText=config.getProperty("usernameSearchText_valid");
		filterSearchObject.searchFilter("userSearchType_containLocator","Contains","userNameSearchFieldLocator", CurrentFilterText);
       //*************ASSERTIONS-Blank Username Scenario***********************
		//filterSearchObject.verifyUsernameSearch(searchText);
		filterSearchObject.verifyValidSearch(CurrentFilterText);
	}
	
	@Test (description="Username Invalid Search criteria-Contains")
    public void invalidUserNameSearch_wrongUserName () throws Exception  {
        //invoke newUserCreation function of New User class
		String CurrentFilterText=config.getProperty("usernameSearchText_invalid");
		filterSearchObject.searchFilter("userSearchType_containLocator","Contains","userNameSearchFieldLocator", CurrentFilterText);
       //*************ASSERTIONS-Blank Username Scenario***********************
		//filterSearchObject.verifyUsernameSearch(searchText);
		filterSearchObject.verifyInvalidSearch(CurrentFilterText);
	}
	
	//*****************Email*********//
	
	@Test ( description="Email Valid Search criteria-Contains ")
    public void validEmailSearch_correctEmail () throws Exception  {
        //invoke newUserCreation function of New User class
		String CurrentFilterText=config.getProperty("emailSearchText_valid");
		filterSearchObject.searchFilter("emailSearchType_containLocator","Contains","emailNameSearchFieldLocator", CurrentFilterText);
       //*************ASSERTIONS-Blank Username Scenario***********************
		//filterSearchObject.verifyUsernameSearch(searchText);
		filterSearchObject.verifyValidSearch(CurrentFilterText);
	}
	
	@Test (enabled=false,description="Email Invalid Search criteria-Contains")
    public void invalidEmailSearch_wrongEmail () throws Exception  {
        //invoke newUserCreation function of New User class
		String CurrentFilterText=config.getProperty("emailSearchText_invalid");
		filterSearchObject.searchFilter("emailSearchType_containLocator","Contains","emailNameSearchFieldLocator", CurrentFilterText);
       //*************ASSERTIONS-Blank Username Scenario***********************
		//filterSearchObject.verifyUsernameSearch(searchText);
		filterSearchObject.verifyInvalidSearch(CurrentFilterText);
	}
}
