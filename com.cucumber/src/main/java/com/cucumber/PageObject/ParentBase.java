package com.cucumber.PageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumber.PageObject.LandingPage.LandingPage;

public class ParentBase  {
	
	public static WebDriver driver;
	public static LandingPage landingPage;
	
	public static WebDriver intilazatio() throws IOException {
		Properties properties = new Properties();
		FileInputStream inputStream = new FileInputStream("./Config.properties");
		properties.load(inputStream);
		String browserString=properties.getProperty(("browser"));
			String chString="Chrome";
		Boolean aBoolean=	browserString.equalsIgnoreCase(chString);
		if(browserString.equalsIgnoreCase(chString)) 
		{
			 driver = new ChromeDriver();	
		}
		else if(browserString.equalsIgnoreCase("Edge")) {
			WebDriver driver = new EdgeDriver();
		}
		else {
			 driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
	}
	
	public LandingPage setdriver() throws IOException {
		driver=intilazatio();
		LandingPage login = new LandingPage(driver);
		login.LoginURLsetup();
		return login;
	}
}
