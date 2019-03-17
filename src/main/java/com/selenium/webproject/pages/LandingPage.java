package com.selenium.webproject.pages;

import com.selenium.webproject.base.BasePage;
import com.selenium.webproject.pages.*;

public class LandingPage extends BasePage {
	public LandingPage() throws InterruptedException {
		super();
	}

	public void gotoProfile() throws InterruptedException {
		click("image_link");
		// return new MyProfilePage();
	}
}
