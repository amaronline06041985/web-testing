package com.selenium.webproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.selenium.webproject.base.*;
public class NewUserPage extends BasePage{
 String actualErrorMessageXpath=objectRepository.getProperty("UserNameBlank");
 String actualErrorMessage=driver.findElement(By.xpath(actualErrorMessageXpath)).getText();
	public NewUserPage() throws InterruptedException {
		super();
	}

	public void dologin(String u_name, String passwrd, String email) throws Exception{
		//Boolean isdataValidValue=BasePage.isDataValid(u_name,passwrd,email);
		//System.out.println("isdataValidValue"+isdataValidValue);
		driver.get(config.getProperty("Url"));
		click("Users");
		click("NewUser");
		input("Username",u_name);
		input("Password",passwrd);
		System.out.println("Password "+passwrd);
		input("Email",email);
		click("createUser");
		/*
		if(isdataValidValue){
		click("Users");
		click("NewUser");
		input("Username",u_name);
		input("Password",passwrd);
		System.out.println("Password "+passwrd);
		input("Email",email);
		click("createUser");
		return new LandingPage();
		
		}else
		return null;
	   */
	}
	//to login with default username and password
	//public LandingPage dologin() throws Exception{
		//return dologin(config.getProperty("defaultUsername"), config.getProperty("defaultPassword"),config.getProperty("defaultEmail"));
	//}
	
	//Verify Username Condition
    public void verifyLoginUserName (String expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//*[@id=\"user_username_input\"]/p")));
        Assert.assertEquals(readText(actualErrorMessageXpath), expectedText);
        System.out.println("Username is blank");
    }

    //Verify Password Condition
    public void verifyLoginPassword (String expectedText) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(actualMessageXpath));
        //Assert.assertEquals(readText(errorMessagePasswordBy), expectedText);
    }
}
