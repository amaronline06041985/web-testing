package com.selenium.webproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.selenium.webproject.base.*;

public class NewUserPage extends BasePage {

	public NewUserPage() throws InterruptedException {
		super();
	}

	public void newUserCreation(String u_name, String passwrd, String email)
			throws Exception {
	
		driver.get(config.getProperty("Url"));
		click("Users");
		click("NewUser");
		input("Username", u_name);
		input("Password", passwrd);
		System.out.println("Password " + passwrd);
		input("Email", email);
		click("createUser");
		
	}

	// Verify New User creation --Success
		public void verifyNewUserCreation(String expectedText) {
			String actualErrorMessageXpath = objectRepository.getProperty("userCreatedSuccessMessage");
				Assert.assertEquals(readText(actualErrorMessageXpath), expectedText);
			
		}

	// Verify Username Condition
	public void verifyLoginUserName(String expectedText) {
		String actualErrorMessageXpath = objectRepository.getProperty("UserNameBlank");
		Assert.assertEquals(readText(actualErrorMessageXpath), expectedText);
	}

	// Verify Password Condition
	public void verifyLoginPassword(String expectedText) {
		String actualErrorMessageXpath = objectRepository.getProperty("PwdBlank");
		Assert.assertEquals(readText(actualErrorMessageXpath), expectedText);
	}
}
