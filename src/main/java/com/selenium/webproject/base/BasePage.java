package com.selenium.webproject.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver = null;
	public static Properties config = null;
	public static Properties objectRepository = null;
	public WebDriverWait wait=null;
    
	public BasePage() throws InterruptedException {
		if (driver == null) {
		//initializing config and Object-Repository properties file
			config = new Properties();
			objectRepository = new Properties();
			try {
				FileInputStream fs = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/java/com/selenium/webproject/resources/Config.properties");			
				config.load(fs);
				fs = new FileInputStream(
						System.getProperty("user.dir")
								+ "/src/test/java/com/selenium/webproject/resources/OR.properties");
				objectRepository.load(fs);
			} catch (Exception e) {
				System.out.println("In the Properties file initialization exception block");
				e.printStackTrace();
			}
			
		//initializing the browser
			String Browser = config.getProperty("browser");
			if (Browser.equals("Mozilla"))
				driver = new FirefoxDriver();
			 
			else if (Browser.equals("Chrome")) {
				final String chromeDriver = "/usr/local/bin/chromedriver";
				System.setProperty("webdriver.chrome.driver", chromeDriver);
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			}
			
		}	
	}
	//Test data validation
	public static Boolean isDataValid(String user_name,String password,String email){
		if(
		   (user_name !=null && !user_name.isEmpty()) &&
		   (password !=null && !password.isEmpty()) &&
		   (email !=null && !email.isEmpty())
		   ){
			return true;
		}
		else 
			return false;
	}
	
	//Click function
	public void click(String xpathKey){
		getElement(xpathKey).click();
	
	}
	
     //Input function
	public void input(String xpathKey, String input_value){
		getElement(xpathKey).sendKeys(input_value);
	}
	//to get the element/object of the page
	public WebElement getElement(String xpathKey){
		String value= objectRepository.getProperty(xpathKey);
		WebElement object=driver.findElement(By.xpath(value));
		return object;
	}
	//Read Text
    public String readText (String elementLocation) {
        return driver.findElement(By.xpath(elementLocation)).getText();
    }
	
}