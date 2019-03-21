package com.selenium.webproject.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.selenium.webproject.pages.*;
import com.selenium.webproject.base.*;

public class newUserCreation_TestScenarios extends BasePage {
	public newUserCreation_TestScenarios() throws InterruptedException {
		super();
	}
	NewUserPage newuser = new NewUserPage();
	
	@AfterTest(description="Closing the browser")
	public void closeBrowser(){
		driver.quit();
	} 
	
	@Test(description="New User Creation--Success")
	public void newUserCreationTest() throws Exception {
		String NewUserNameValue=config.getProperty("user");
		String NewPasswordValue=config.getProperty("pass");
		String NewEmailValue=config.getProperty("email");
		newuser.newUserCreation(NewUserNameValue,NewPasswordValue, NewEmailValue);
		
		//*************ASSERTIONS-Success Scenario***********************
				newuser.verifyNewUserCreation("User was successfully created.");
		}	
		
	@Test (enabled=false, description="Empty Username Scenario")
    public void invalidLoginTest_EmptyUserName () throws Exception  {
        //invoke newUserCreation function of New User class
		newuser.newUserCreation("","pass7", "testemail7@gmail.com");
 
        //*************ASSERTIONS-Blank Username Scenario***********************
		newuser.verifyLoginUserName("can't be blank");

    }
	@Test(description="Empty Password Scenario")
    public void invalidLoginTest_EmptyPassword () throws Exception  {
        //invoke newUserCreation function of NewUserPage class
		newuser.newUserCreation("User123","", "testemail7@gmail.com");
 
        //*************ASSERTIONS-Blank Password Scenario***********************
		newuser.verifyLoginPassword("can't be blank");

    }
	}

