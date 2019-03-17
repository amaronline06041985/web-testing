package com.selenium.webproject.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.webproject.pages.*;
import com.selenium.webproject.base.*;

public class newUserTest_creationSuccess extends BasePage {
	public newUserTest_creationSuccess() throws InterruptedException {
		super();
	}
	NewUserPage newuser = new NewUserPage();
	/*@Test
	public void newUserCreation() throws Exception {
		
		String NewUserNameValue=config.getProperty("user");
		String NewPasswordValue=config.getProperty("pass");
		//String NewPasswordValue="";
		String NewEmailValue=config.getProperty("email");
		LandingPage landingpage = newuser.dologin(NewUserNameValue,
		NewPasswordValue, NewEmailValue);
		if (landingpage == null){
			System.out.println("Test Case failed");
		}
		else
			System.out.println("Test Case Passed");
		//Assert.assertTrue(landingpage != null, "WRONG DATA");
		
		}	
		*/
	@Test
    public void invalidLoginTest_EmptyUserEmptyPassword () throws Exception  {
        //invoke dologin function of New User class
		newuser.dologin("","pass7", "testemail7@gmail.com");
 
        //*************ASSERTIONS***********************
		newuser.verifyLoginUserName("can't be blank");

    }
	}

